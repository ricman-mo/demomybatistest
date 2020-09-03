drop database BASE_DCIM;

create database BASE_DCIM;

use BASE_DCIM;

create table tbl_user (
  id  BINARY(16) primary key  COMMENT "ID",
  account varchar(20) not null unique COMMENT "帐号",
  password varchar(80) not null COMMENT "密码",
  username varchar(20) not null COMMENT "昵称",
  create_time datetime not null COMMENT "创建时间"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "用户表";

CREATE TABLE tbl_role (
  id  id int primary key auto_increment COMMENT "ID",
  name varchar(128) not null unique COMMENT "角色名称"
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "角色表";


CREATE TABLE tbl_permission (
  id int primary key auto_increment COMMENT "ID",
  name varchar(128) COMMENT '资源名称',
  per_code varchar(128) not null unique COMMENT '权限代码字符串'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "资源表";

CREATE TABLE tbl_user_role (
  id int primary key auto_increment COMMENT "ID",
  user_id int not null COMMENT '用户id',
  role_id int not null COMMENT '角色id',
  foreign key (user_id) references tbl_user (id),
  foreign key (role_id) references tbl_role (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "用户角色表";

CREATE TABLE tbl_role_permission (
  id int primary key auto_increment COMMENT "ID",
  role_id int not null COMMENT '角色id',
  permission_id int not null COMMENT '权限id',
  foreign key (role_id) references tbl_role (id),
  foreign key (permission_id) references tbl_permission (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT "角色资源表";
