package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * Created by M93349 on 2020/8/19.
 */
@TableName("user_role")
public class UserRole implements Serializable {
  private static final long serialVersionUID = -3397516891053950951L;

  /**
   * ID
   */
  @TableId(value = "id",type = IdType.AUTO)
  private Integer id;

  /**
   * 用户id
   */
  @TableField(value = "user_id")
  private Integer userId;

  /**
   * 角色id
   */
  @TableField(value  = "role_id")
  private Integer roleId;

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
   * 获取用户id
   *
   * @return user_id - 用户id
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * 设置用户id
   *
   * @param userId 用户id
   */
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * 获取角色id
   *
   * @return role_id - 角色id
   */
  public Integer getRoleId() {
    return roleId;
  }

  /**
   * 设置角色id
   *
   * @param roleId 角色id
   */
  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }
}
