package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import java.util.List;

/**
 * Created by M93349 on 2020/8/19.
 */
public interface RoleMapper extends BaseMapper<Role> {
  List<Role> findRoleByUser(User userDto);
}
