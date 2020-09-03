package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserRoleMapper;
import com.example.demo.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * Created by M93349 on 2020/8/20.
 */
@Service
public class UserRoleServiceImpl  extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
}
