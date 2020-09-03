package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.Permission;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import java.util.List;

/**
 * Created by M93349 on 2020/8/20.
 */
public interface IPermissionService  extends IService<Permission> {
  List<Permission> findPermissionByRole(Role role);
}
