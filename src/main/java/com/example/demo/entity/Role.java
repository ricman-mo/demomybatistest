package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import java.io.Serializable;

/**
 * Created by M93349 on 2020/8/19.
 */
@TableName("role")
public class Role implements Serializable {
  private static final long serialVersionUID = 6382925944937625109L;

  /**
   * ID
   */
  @TableId(value = "id",type = IdType.AUTO)
  private Integer id;

  /**
   * 角色名称
   */
  private String name;

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
   * 获取角色名称
   *
   * @return name - 角色名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置角色名称
   *
   * @param name 角色名称
   */
  public void setName(String name) {
    this.name = name;
  }
}
