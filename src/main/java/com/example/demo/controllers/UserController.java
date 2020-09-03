package com.example.demo.controllers;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.entity.common.BaseDto;
import com.example.demo.entity.common.Constant;
import com.example.demo.entity.common.ResponseBean;
import com.example.demo.exception.CustomException;
import com.example.demo.exception.CustomUnauthorizedException;
import com.example.demo.service.IUserService;
import com.example.demo.util.AesCipherUtil;
import com.example.demo.util.JedisUtil;
import com.example.demo.util.JwtUtil;
import com.example.demo.util.UserUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by M93349 on 2020/8/21.
 */
@RestController
@RequestMapping("/user")
@PropertySource("classpath:redisconfig.properties")
public class UserController {
  /**
   * RefreshToken过期时间
   */
  @Value("${refreshTokenExpireTime}")
  private String refreshTokenExpireTime;

  private final UserUtil userUtil;

  private final IUserService userService;

  @Autowired
  public UserController(UserUtil userUtil, IUserService userService) {
    this.userUtil = userUtil;
    this.userService = userService;
  }

  @GetMapping
  @RequiresPermissions(logical = Logical.AND, value = {"user:view"})
  public ResponseBean user() {

    Page<User> page = new Page<>();
    userService.page(page, null);

    if (page == null || page.getSize() < 0) {
      throw new CustomException("查询失败(Query Failure)");
    }
    Map<String, Object> result = new HashMap<String, Object>(16);
    result.put("count", page.getTotal());
    result.put("data", page.getRecords());
    return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", result);
  }

  @PostMapping("/login")
  public ResponseBean login(@RequestBody User userDto, HttpServletResponse httpServletResponse) {
    // 查询数据库中的帐号信息
    String account = userDto.getAccount();
    User userDtoTemp = this.userService.getOne(new QueryWrapper<User>().lambda().eq(User::getAccount, account));

    if (userDtoTemp == null) {
      throw new CustomUnauthorizedException("该帐号不存在(The account does not exist.)");
    }
    // 密码进行AES解密
    String key = AesCipherUtil.deCrypto(userDtoTemp.getPassword());
    // 因为密码加密是以帐号+密码的形式进行加密的，所以解密后的对比是帐号+密码
    if (key.equals(userDto.getAccount() + userDto.getPassword())) {
      // 清除可能存在的Shiro权限信息缓存
      if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + userDto.getAccount())) {
        JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + userDto.getAccount());
      }
      // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
      String currentTimeMillis = String.valueOf(System.currentTimeMillis());
      JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + userDto.getAccount(), currentTimeMillis, Integer.parseInt(refreshTokenExpireTime));
      // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
      String token = JwtUtil.sign(userDto.getAccount(), currentTimeMillis);
      httpServletResponse.setHeader("Authorization", token);
      httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
      return new ResponseBean(HttpStatus.OK.value(), "登录成功(Login Success.)", null);
    } else {
      throw new CustomUnauthorizedException("帐号或密码错误(Account or Password Error.)");
    }
  }
}
