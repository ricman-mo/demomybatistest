package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.mapper.RoleMapper;
import com.example.demo.mapper.UserRoleMapper;
import com.example.demo.service.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by M93349 on 2020/8/20.
 */
@Service
public class RoleServiceImpl  extends ServiceImpl<RoleMapper, Role> implements IRoleService {
  @Override
  public List<Role> findRoleByUser(User userDto) {
    return this.baseMapper.findRoleByUser(userDto);
  }
}