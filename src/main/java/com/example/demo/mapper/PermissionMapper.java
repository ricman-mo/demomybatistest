package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Permission;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by M93349 on 2020/8/19.
 */
public interface PermissionMapper extends BaseMapper<Permission> {
  List<Permission> findPermissionByRole(Role role);
}
