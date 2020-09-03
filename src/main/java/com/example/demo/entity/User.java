package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by M93349 on 2020/8/13.
 */
@TableName("user")
public class User   implements Serializable {
  private static final long serialVersionUID = 3342723124953988435L;

  /**
   * ID
   */
  @TableId(value = "id",type = IdType.AUTO)
  private Integer id;

  /**
   * 帐号
   */
  @TableField(insertStrategy = FieldStrategy.NOT_NULL, updateStrategy = FieldStrategy.NOT_NULL)
  private String account;

  /**
   * 密码
   */
  @TableField(insertStrategy = FieldStrategy.NOT_NULL, updateStrategy = FieldStrategy.NOT_NULL)
  private String password;

  /**
   * 昵称
   */
  @TableField(insertStrategy = FieldStrategy.NOT_NULL, updateStrategy = FieldStrategy.NOT_NULL)
  private String username;

  /**
   * 注册时间
   */
  @TableField(value="reg_time")
  private Date regTime;

  /**
   * 获取ID
   *
   * @return id - ID
   */
  public Integer getId() {
    return id;
  }

  /**
   * 设置ID
   *
   * @param id ID
   */
  public void setId(Integer id) {
    this.id = id;
  }

  /**
   * 获取帐号
   *
   * @return account - 帐号
   */
  public String getAccount() {
    return account;
  }

  /**
   * 设置帐号
   *
   * @param account 帐号
   */
  public void setAccount(String account) {
    this.account = account;
  }

  /**
   * 获取密码
   *
   * @return password - 密码
   */
  public String getPassword() {
    return password;
  }

  /**
   * 设置密码
   *
   * @param password 密码
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * 获取昵称
   *
   * @return username - 昵称
   */
  public String getUsername() {
    return username;
  }

  /**
   * 设置昵称
   *
   * @param username 昵称
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * 获取注册时间
   *
   * @return reg_time - 注册时间
   */
  public Date getRegTime() {
    return regTime;
  }

  /**
   * 设置注册时间
   *
   * @param regTime 注册时间
   */
  public void setRegTime(Date regTime) {
    this.regTime = regTime;
  }
}
