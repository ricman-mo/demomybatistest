package com.example.demo.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.User;
import com.example.demo.entity.common.Constant;
import com.example.demo.exception.CustomException;
import com.example.demo.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by M93349 on 2020/8/21.
 */
@Component
public class UserUtil {

  private final IUserService userService;

  @Autowired
  public UserUtil(IUserService userService) {
    this.userService = userService;
  }

  /**
   * 获取当前登录用户
   *
   * @param
   */
  public User getUser() {
    String account = this.getAccount();
    User user = this.userService.getOne(new QueryWrapper<User>().lambda().eq(User::getAccount, account));
    // 用户是否存在
    if (user == null) {
      throw new CustomException("该帐号不存在(The account does not exist.)");
    }
    return user;
  }

  public Integer getUserId() {
    return getUser().getId();
  }

  public String getToken() {
    return SecurityUtils.getSubject().getPrincipal().toString();
  }

  public String getAccount() {
    String token = SecurityUtils.getSubject().getPrincipal().toString();
    // 解密获得Account
    return JwtUtil.getClaim(token, Constant.ACCOUNT);
  }


}
