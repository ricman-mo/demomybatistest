package com.example.demo.config.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.config.shiro.jwt.JwtToken;
import com.example.demo.entity.Permission;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.common.Constant;
import com.example.demo.service.IPermissionService;
import com.example.demo.service.IRoleService;
import com.example.demo.service.IUserService;
import com.example.demo.util.JedisUtil;
import com.example.demo.util.JwtUtil;
import com.example.demo.util.StringUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by M93349 on 2020/8/20.
 */
@Service
public class UserRealm  extends AuthorizingRealm {

  private  IUserService userService;
  private IRoleService roleService;
  private IPermissionService permissionService;

  @Autowired
  public UserRealm(IUserService userService, IRoleService roleService, IPermissionService permissionService) {
    this.userService = userService;
    this.roleService = roleService;
    this.permissionService = permissionService;
  }

  @Override
  public boolean supports(AuthenticationToken authenticationToken) {
    return authenticationToken instanceof JwtToken;
  }

  // 第四步执行
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
    String account = JwtUtil.getClaim(principalCollection.toString(), Constant.ACCOUNT);
    User userDto = new User();
    userDto.setAccount(account);
    List<Role> roles = roleService.findRoleByUser(userDto);
    for (Role role : roles) {
      if(role !=null) {
        // 添加角色
        simpleAuthorizationInfo.addRole(role.getName());
        // 根据用户角色查询权限
        List<Permission> permissionDtos = permissionService.findPermissionByRole(role);
        for (Permission permission : permissionDtos) {
          if (permission != null) {
            // 添加权限
            simpleAuthorizationInfo.addStringPermission(permission.getPerCode());
          }
        }
      }
    }
    return simpleAuthorizationInfo;
  }

  // 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
  //第五步执行
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
    String token = (String) authenticationToken.getCredentials();
    // 解密获得account，用于和数据库进行对比
    String account = JwtUtil.getClaim(token, Constant.ACCOUNT);
    // 帐号为空
    if (StringUtil.isBlank(account)) {
      throw new AuthenticationException("Token中帐号为空(The account in Token is empty.)");
    }
    // 查询用户是否存在
    User userDto = userService.getOne(new QueryWrapper<User>().lambda().eq(User::getAccount, account));
    if (userDto == null) {
      throw new AuthenticationException("该帐号不存在(The account does not exist.)");
    }
    // 开始认证，要AccessToken认证通过，且Redis中存在RefreshToken，且两个Token时间戳一致
    if (JwtUtil.verify(token) && JedisUtil.exists(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account)) {
      // 获取RefreshToken的时间戳
      String currentTimeMillisRedis = JedisUtil.getObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + account).toString();
      // 获取AccessToken时间戳，与RefreshToken的时间戳对比
      if (JwtUtil.getClaim(token, Constant.CURRENT_TIME_MILLIS).equals(currentTimeMillisRedis)) {
        return new SimpleAuthenticationInfo(token, token, "userRealm");
      }
    }
    throw new AuthenticationException("Token已过期(Token expired or incorrect.)");
  }
}
