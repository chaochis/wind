CREATE TABLE `wind_admin_account` (
                                      `account_id` varchar(255) NOT NULL COMMENT '账号的主键',
                                      `account_name` varchar(600) NOT NULL COMMENT '登录账号(如:手机号等)',
                                      `account_type` int NOT NULL COMMENT '账号类别的值',
                                      `account_type_text` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号类别中文解释',
                                      `account_status` int NOT NULL DEFAULT '0' COMMENT '账号状态 0 - 未激活 1 - 正常 2 - 已删除',
                                      `account_status_text` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号状态中文解释',
                                      `user_id` varchar(255) DEFAULT NULL COMMENT '关联的用户id',
                                      `create_by_id` varchar(255) NOT NULL COMMENT '创建该账户的user_id',
                                      `create_date` datetime NOT NULL COMMENT '创建该账户的时间',
                                      `update_by_id` varchar(255) NOT NULL COMMENT '最近一次更新账户关联的人的user_id',
                                      `update_date` datetime NOT NULL COMMENT '最近一次更新账户关联的时间',
                                      `login_ip` varchar(255) NOT NULL COMMENT '该账号最近一次的登录ip',
                                      `login_date` datetime NOT NULL COMMENT '该账号最近一次的登录时间',
                                      `account_password` varchar(255) NOT NULL COMMENT '用户密码',
                                      `account_password_salt` varchar(255) NOT NULL COMMENT '风旅用户密码盐值',
                                      PRIMARY KEY (`account_id`),
                                      UNIQUE KEY `wind_account_account_id_uindex` (`account_id`),
                                      UNIQUE KEY `wind_account_account_name_uindex` (`account_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='风旅账号表(关联用户表用)'

CREATE TABLE `wind_department` (
                                   `department_id` varchar(255) NOT NULL COMMENT '部门id',
                                   `department_name` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
                                   `department_parent_id` varchar(255) NOT NULL COMMENT '父级部门id',
                                   `department_ancestors` varchar(600) NOT NULL COMMENT '部门祖级列表',
                                   `department_order_num` int NOT NULL DEFAULT '1' COMMENT '同级显示顺序',
                                   `department_status` int NOT NULL DEFAULT '0' COMMENT '部门状态 0 - 未激活 1 - 正常 2 - 已删除',
                                   `department_status_text` varchar(255) NOT NULL COMMENT '部门状态中文解释',
                                   `create_by_id` varchar(255) NOT NULL COMMENT '部门创建人的userId',
                                   `update_by_id` varchar(255) NOT NULL COMMENT '最近一次更新部门信息的人的userId',
                                   `update_date` datetime NOT NULL COMMENT '最近一次更新部门信息的时间',
                                   `create_date` datetime NOT NULL COMMENT '部门创建时间',
                                   PRIMARY KEY (`department_id`),
                                   UNIQUE KEY `wind_department_department_id_uindex` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='wind部门表'

CREATE TABLE `wind_permission` (
                                   `permission_id` varchar(255) NOT NULL COMMENT '权限id',
                                   `permission_name` varchar(255) NOT NULL COMMENT '权限名称',
                                   `permission_name_text` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限中文名称',
                                   `permission_menu_path` varchar(600) DEFAULT NULL COMMENT '菜单路径(只有菜单权限可以设置)',
                                   `permission_parent_id` varchar(255) NOT NULL COMMENT '父级id',
                                   `permission_menu_component` varchar(600) DEFAULT NULL COMMENT '路由组件(只有菜单权限可以设置)',
                                   `permission_menu_query` text COMMENT '路由参数(只有菜单权限可以设置)',
                                   `permission_icon` varchar(255) DEFAULT NULL COMMENT '路由的图标',
                                   `permission_order_num` int NOT NULL DEFAULT '0' COMMENT '同级顺序',
                                   `permission_visible` int NOT NULL DEFAULT '0' COMMENT '菜单或者权限是否可见 0 - 不可见 1 - 可见',
                                   `permission_status` int NOT NULL DEFAULT '0' COMMENT '菜单或者权限的状态 0 - 未激活 1 - 正常 2 已删除',
                                   `permission_status_text` varchar(255) NOT NULL COMMENT '权限状态中文解释',
                                   `permission_code` varchar(600) NOT NULL COMMENT '权限标识',
                                   `create_by_id` varchar(255) NOT NULL COMMENT '创建该权限的人的userId',
                                   `create_date` datetime NOT NULL COMMENT '该权限的创建时间',
                                   `update_by_id` varchar(255) NOT NULL COMMENT '更新该权限信息的人的userId',
                                   `update_date` datetime NOT NULL COMMENT '更新该权限信息的时间',
                                   `permission_type` int NOT NULL COMMENT '权限类别 0 - 菜单权限 1 - 按钮权限',
                                   `permission_type_text` varchar(255) NOT NULL COMMENT '权限类别中文解释',
                                   PRIMARY KEY (`permission_id`),
                                   UNIQUE KEY `wind_permission_permission_id_uindex` (`permission_id`),
                                   UNIQUE KEY `wind_permission_permission_name_text_uindex` (`permission_name_text`),
                                   UNIQUE KEY `wind_permission_permission_name_uindex` (`permission_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='风旅后端权限表'

CREATE TABLE `wind_role` (
                             `role_id` varchar(255) NOT NULL COMMENT '角色id',
                             `role_name` varchar(255) NOT NULL COMMENT '角色名称',
                             `role_name_text` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称中文说明',
                             `role_status` char(2) NOT NULL DEFAULT '0' COMMENT '角色状态 0 - 未激活 1 - 正常 2 - 已删除',
                             `create_by_id` varchar(255) NOT NULL COMMENT '角色创建人的userId',
                             `create_date` datetime NOT NULL COMMENT '角色的创建时间',
                             `update_by_id` varchar(255) NOT NULL COMMENT '最近一次更新角色信息的人的userId',
                             `update_date` datetime NOT NULL COMMENT '最近一次更新角色信息的时间',
                             PRIMARY KEY (`role_id`),
                             UNIQUE KEY `wind_role_role_id_uindex` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='风旅角色表'

CREATE TABLE `wind_role_permission_relation` (
                                                 `relation_id` varchar(255) NOT NULL COMMENT '关联id',
                                                 `permission_id` varchar(255) NOT NULL COMMENT '权限id',
                                                 `role_id` varchar(255) NOT NULL COMMENT '角色id',
                                                 `create_by_id` varchar(255) NOT NULL COMMENT '创建该关联关系的人的userId',
                                                 `create_date` datetime NOT NULL COMMENT '该关联的创建时间',
                                                 PRIMARY KEY (`relation_id`),
                                                 UNIQUE KEY `wind_role_permission_relation_relation_id_uindex` (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色权限关联表'

CREATE TABLE `wind_user` (
                             `user_id` varchar(255) NOT NULL COMMENT '用户主键',
                             `user_level` int NOT NULL DEFAULT '0' COMMENT '用户等级',
                             `user_status` int NOT NULL DEFAULT '0' COMMENT '用户状态 0 - 未激活 1 - 正常 2 - 已删除',
                             `user_nick_name` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户昵称',
                             `user_sex` int DEFAULT '0' COMMENT '0 - 保密 1 - 男 2 - 女 ',
                             `user_sex_text` varchar(255) DEFAULT NULL COMMENT '用户性别中文解释',
                             `user_avatar` varchar(300) DEFAULT NULL COMMENT '用户头像地址',
                             `create_by_id` varchar(255) NOT NULL COMMENT '创建人的userId',
                             `create_date` datetime NOT NULL COMMENT '创建时间',
                             `update_by_id` varchar(255) NOT NULL COMMENT '最近一次更新用户信息的人的userid',
                             `update_date` datetime NOT NULL COMMENT '最近一次更新用户信息的时间',
                             `user_email` varchar(255) DEFAULT NULL COMMENT '用户邮箱',
                             `user_mobile` varchar(20) DEFAULT NULL COMMENT '用户手机号',
                             `user_real_name` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户的真实姓名',
                             PRIMARY KEY (`user_id`),
                             UNIQUE KEY `wind_user_user_id_uindex` (`user_id`),
                             UNIQUE KEY `wind_user_user_nick_name_uindex` (`user_nick_name`),
                             UNIQUE KEY `wind_user_user_email_uindex` (`user_email`),
                             UNIQUE KEY `wind_user_user_mobile_uindex` (`user_mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='风旅用户表'

CREATE TABLE `wind_user_department_relation` (
                                                 `relation_id` varchar(255) NOT NULL COMMENT '关联id',
                                                 `user_id` varchar(255) NOT NULL COMMENT '用户id',
                                                 `department_id` varchar(255) NOT NULL COMMENT '部门id',
                                                 `create_by_id` varchar(255) NOT NULL COMMENT '创建该关联的人的userId',
                                                 `rcreate_date` datetime NOT NULL COMMENT '创建时间',
                                                 PRIMARY KEY (`relation_id`),
                                                 UNIQUE KEY `wind_user_department_relation_relation_id_uindex` (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='风旅用户部门关联表'

CREATE TABLE `wind_user_group` (
                                   `user_group_id` varchar(255) NOT NULL COMMENT '用户组的id',
                                   `user_group_name` varchar(255) NOT NULL COMMENT '用户组名称',
                                   `user_group_name_text` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户组中文名称',
                                   `user_group_parent_id` varchar(255) NOT NULL COMMENT '父级用户组id',
                                   `user_group_parent_ancestor` varchar(600) NOT NULL COMMENT '父级用户层级',
                                   `user_group_status` int NOT NULL COMMENT '用户组状态',
                                   `user_group_status_text` varchar(255) NOT NULL COMMENT '用户组状态中文解释',
                                   `create_by_id` varchar(255) NOT NULL COMMENT '创建该用户组的人的userId',
                                   `create_date` datetime NOT NULL COMMENT '创建该用户组的时间',
                                   `update_by_id` varchar(255) NOT NULL COMMENT '最近一次更新该用户组的人的userId',
                                   `update_date` varchar(255) NOT NULL COMMENT '最近一次更新该用户组的时间',
                                   PRIMARY KEY (`user_group_id`),
                                   UNIQUE KEY `user_group_name` (`user_group_name`),
                                   UNIQUE KEY `wind_user_group_user_group_id_uindex` (`user_group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户组表(暂时不用)'

CREATE TABLE `wind_user_group_role_relation` (
                                                 `relation_id` varchar(255) NOT NULL COMMENT '主键',
                                                 `user_group_id` varchar(255) NOT NULL COMMENT '用户组id',
                                                 `role_id` varchar(255) NOT NULL COMMENT '角色id',
                                                 `create_by_id` varchar(255) NOT NULL COMMENT '关联创建人的userId',
                                                 `create_date` datetime NOT NULL COMMENT '关联创建时间',
                                                 PRIMARY KEY (`relation_id`),
                                                 UNIQUE KEY `wind_user_group_role_relation_relation_id_uindex` (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户组角色关联表'

CREATE TABLE `wind_user_group_user_relation` (
                                                 `relation_id` varchar(255) NOT NULL COMMENT '关联id',
                                                 `user_id` varchar(255) NOT NULL COMMENT '用户id',
                                                 `user_group_id` varchar(255) NOT NULL COMMENT '用户组id',
                                                 `create_by_id` varchar(255) NOT NULL COMMENT '创建该关联的人的user_id',
                                                 `create_date` datetime NOT NULL COMMENT '创建该关联的时间',
                                                 PRIMARY KEY (`relation_id`),
                                                 UNIQUE KEY `wind_user_group_user_relation_relation_id_uindex` (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户与用户组关联表'

CREATE TABLE `wind_user_role_relation` (
                                           `user_id` varchar(255) NOT NULL COMMENT '用户id',
                                           `role_id` varchar(255) NOT NULL COMMENT '角色id',
                                           `relation_id` varchar(255) NOT NULL COMMENT '关联id',
                                           `create_by_id` varchar(255) NOT NULL COMMENT '创建关联信息的创建人的userId',
                                           `create_date` datetime NOT NULL COMMENT ' 创建关联信息的时间',
                                           PRIMARY KEY (`relation_id`),
                                           UNIQUE KEY `wind_user_role_relation_relation_id_uindex` (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='风旅角色用户关联信息表'

CREATE TABLE `wx_account` (
                              `account_id` varchar(255) NOT NULL COMMENT '生成账户id',
                              `union_id` varchar(255) DEFAULT NULL COMMENT '微信的union_id',
                              `open_id` varchar(255) DEFAULT NULL COMMENT '微信的open_id',
                              `wx_nick_name` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信用户昵称',
                              `wx_avatar` varchar(600) DEFAULT NULL COMMENT '微信用户头像地址',
                              `register_ip` varchar(60) NOT NULL COMMENT '注册ip',
                              `login_ip` varchar(60) NOT NULL COMMENT '最近一次登录的ip地址',
                              `register_date` datetime NOT NULL COMMENT '注册时间',
                              `login_date` datetime NOT NULL COMMENT '最近一次登录的时间',
                              `token` varchar(255) DEFAULT NULL COMMENT '微信用户最近一次登录持有的token',
                              `user_id` varchar(255) DEFAULT NULL COMMENT '关联的用户表的user_id',
                              `account_status` int NOT NULL COMMENT '账号状态',
                              `account_status_text` varchar(255) NOT NULL COMMENT '账号状态中文解释',
                              `update_by_id` varchar(255) NOT NULL COMMENT '最近一次更新该微信账户状态的人的userId',
                              `update_date` datetime NOT NULL COMMENT '最近一次更新该微信账户状态的时间',
                              `account_type` int NOT NULL COMMENT '账号类别(此表固定是微信账号)',
                              `account_type_text` varchar(255) NOT NULL COMMENT '账号类别中文解释',
                              PRIMARY KEY (`account_id`),
                              UNIQUE KEY `wx_account_account_id_uindex` (`account_id`),
                              UNIQUE KEY `wx_account_token_uindex` (`token`),
                              UNIQUE KEY `wx_account_open_id_uindex` (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='微信注册用户'


