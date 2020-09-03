DELETE FROM tbl_user;
DELETE FROM tbl_role;
DELETE FROM tbl_user_role;
DELETE FROM tbl_permission;
DELETE FROM tbl_role_permission;

/* 密码都是帐号 */
insert into tbl_user values(null, "admin", "QUJBNUYyM0M3OTNEN0I4MUFBOTZBOTkwOEI1NDI0MUE=", "admin", now());

insert into tbl_role values(null, "admin");
insert into tbl_role values(null, "customer");

insert into tbl_user_role values(null, 1, 1);
insert into tbl_user_role values(null, 2, 2);

insert into tbl_permission values(null, "查看用户", "user:view");
insert into tbl_permission values(null, "操作用户", "user:edit");

insert into tbl_role_permission values(null, 1, 1);
insert into tbl_role_permission values(null, 1, 2);
insert into tbl_role_permission values(null, 2, 1);