package com.example.demo.config.shiro.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by M93349 on 2020/8/20.
 */
public class JwtToken implements AuthenticationToken {
  /**
   * Token
   */
  private String token;

  public JwtToken(String token) {
    this.token = token;
  }

  @Override
  public Object getPrincipal() {
    return token;
  }

  @Override
  public Object getCredentials() {
    return token;
  }
}