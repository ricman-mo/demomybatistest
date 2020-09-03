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
@TableName("permission")
public class Permission implements Serializable {
  private static final long serialVersionUID = -8834983208597107688L;

  /**
   * ID
   */
  @TableId(value = "id",type = IdType.AUTO)
  private Integer id;

  /**
   * 资源名称
   */
  private String name;

  /**
   * 权限代码字符串
   */
  @TableField(value = "per_code")
  private String perCode;

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
   * 获取资源名称
   *
   * @return name - 资源名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置资源名称
   *
   * @param name 资源名称
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获取权限代码字符串
   *
   * @return per_code - 权限代码字符串
   */
  public String getPerCode() {
    return perCode;
  }

  /**
   * 设置权限代码字符串
   *
   * @param perCode 权限代码字符串
   */
  public void setPerCode(String perCode) {
    this.perCode = perCode;
  }
}