package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.RolePermission;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.mapper.RolePermissionMapper;
import com.example.demo.mapper.UserRoleMapper;
import com.example.demo.service.IRolePermissionService;
import org.springframework.stereotype.Service;

/**
 * Created by M93349 on 2020/8/20.
 */
@Service
public class RolePermissionServiceImpl  extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {
}
