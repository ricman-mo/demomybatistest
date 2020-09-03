package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import java.io.Serializable;

/**
 * Created by M93349 on 2020/8/19.
 */
@TableName("role_permission")
public class RolePermission implements Serializable {
  private static final long serialVersionUID = -8564770707000796503L;

  /**
   * ID
   */
  @TableId(value = "id",type = IdType.AUTO)
  private Integer id;

  /**
   * 角色id
   */
  @TableField(value = "role_id")
  private Integer roleId;

  /**
   * 权限id
   */
  @TableField(value = "permission_id")
  private Integer permissionId;

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

  /**
   * 获取权限id
   *
   * @return permission_id - 权限id
   */
  public Integer getPermissionId() {
    return permissionId;
  }

  /**
   * 设置权限id
   *
   * @param permissionId 权限id
   */
  public void setPermissionId(Integer permissionId) {
    this.permissionId = permissionId;
  }
}
