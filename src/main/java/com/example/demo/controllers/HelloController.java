package com.example.demo.controllers;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.Permission;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.mapper.PermissionMapper;
import com.example.demo.service.Impl.PermissionServiceImpl;
import com.example.demo.service.Impl.RoleServiceImpl;
import com.example.demo.service.Impl.UserServiceImpl;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by M93349 on 2020/8/13.
 */
@RestController
public class HelloController {



  @GetMapping("/hello")
  @RequiresPermissions(logical = Logical.AND, value = {"user:view"})
  public String SayHello() {

    return  "Hello";
  }
}
