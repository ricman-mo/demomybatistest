package com.example.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Created by M93349 on 2020/8/20.
 */
@Service
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements IUserService {
}
