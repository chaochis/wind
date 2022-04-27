CREATE DATABASE `wind` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */

create table wind_account
(
    account_id            varchar(255)              not null comment '账号的主键'
        primary key,
    account_name          varchar(600)              not null comment '登录账号(如:手机号等)',
    account_type          int                       not null comment '账号类别的值',
    account_type_text     varchar(600) charset utf8 not null comment '账号类别中文解释',
    account_status        int default 0             not null comment '账号状态 0 - 未激活 1 - 正常 2 - 已删除',
    account_status_text   varchar(600) charset utf8 not null comment '账号状态中文解释',
    user_id               varchar(255)              not null comment '关联的用户id',
    create_by_id          varchar(255)              not null comment '创建该账户的user_id',
    create_date           datetime                  not null comment '创建该账户的时间',
    update_by_id          varchar(255)              not null comment '最近一次更新账户关联的人的user_id',
    update_date           datetime                  not null comment '最近一次更新账户关联的时间',
    login_ip              varchar(255)              not null comment '该账号最近一次的登录ip',
    login_date            datetime                  not null comment '该账号最近一次的登录时间',
    account_password      varchar(255)              not null comment '用户密码',
    account_password_salt varchar(255)              not null comment '风旅用户密码盐值',
    constraint wind_account_account_id_uindex
        unique (account_id),
    constraint wind_account_account_name_uindex
        unique (account_name)
)
    comment '风旅账号表(关联用户表用)';

create table wind_department
(
    department_id          varchar(255)              not null comment '部门id'
        primary key,
    department_name        varchar(300) charset utf8 not null comment '部门名称',
    department_parent_id   varchar(255)              not null comment '父级部门id',
    department_ancestors   varchar(600)              not null comment '部门祖级列表',
    department_order_num   int default 1             not null comment '同级显示顺序',
    department_status      int default 0             not null comment '部门状态 0 - 未激活 1 - 正常 2 - 已删除',
    department_status_text varchar(255)              not null comment '部门状态中文解释',
    create_by_id           varchar(255)              not null comment '部门创建人的userId',
    update_by_id           varchar(255)              not null comment '最近一次更新部门信息的人的userId',
    update_date            datetime                  not null comment '最近一次更新部门信息的时间',
    create_date            datetime                  not null comment '部门创建时间',
    constraint wind_department_department_id_uindex
        unique (department_id)
)
    comment 'wind部门表';

create table wind_permission
(
    permission_id             varchar(255)              not null comment '权限id'
        primary key,
    permission_name           varchar(255)              not null comment '权限名称',
    permission_name_text      varchar(300) charset utf8 not null comment '权限中文名称',
    permission_menu_path      varchar(600)              null comment '菜单路径(只有菜单权限可以设置)',
    permission_parent_id      varchar(255)              not null comment '父级id',
    permission_menu_component varchar(600)              null comment '路由组件(只有菜单权限可以设置)',
    permission_menu_query     text                      null comment '路由参数(只有菜单权限可以设置)',
    permission_icon           varchar(255)              null comment '路由的图标',
    permission_order_num      int default 0             not null comment '同级顺序',
    permission_visible        int default 0             not null comment '菜单或者权限是否可见 0 - 不可见 1 - 可见',
    permission_status         int default 0             not null comment '菜单或者权限的状态 0 - 未激活 1 - 正常 2 已删除',
    permission_status_text    varchar(255)              not null comment '权限状态中文解释',
    permission_code           varchar(600)              not null comment '权限标识',
    create_by_id              varchar(255)              not null comment '创建该权限的人的userId',
    create_date               datetime                  not null comment '该权限的创建时间',
    update_by_id              varchar(255)              not null comment '更新该权限信息的人的userId',
    update_date               datetime                  not null comment '更新该权限信息的时间',
    permission_type           int                       not null comment '权限类别 0 - 菜单权限 1 - 按钮权限',
    permission_type_text      varchar(255)              not null comment '权限类别中文解释',
    constraint wind_permission_permission_id_uindex
        unique (permission_id),
    constraint wind_permission_permission_name_text_uindex
        unique (permission_name_text),
    constraint wind_permission_permission_name_uindex
        unique (permission_name)
)
    comment '风旅后端权限表';

create table wind_role
(
    role_id        varchar(255)              not null comment '角色id'
        primary key,
    role_name      varchar(255)              not null comment '角色名称',
    role_name_text varchar(300) charset utf8 not null comment '角色名称中文说明',
    role_status    char(2) default '0'       not null comment '角色状态 0 - 未激活 1 - 正常 2 - 已删除',
    create_by_id   varchar(255)              not null comment '角色创建人的userId',
    create_date    datetime                  not null comment '角色的创建时间',
    update_by_id   varchar(255)              not null comment '最近一次更新角色信息的人的userId',
    update_date    datetime                  not null comment '最近一次更新角色信息的时间',
    constraint wind_role_role_id_uindex
        unique (role_id)
)
    comment '风旅角色表';

create table wind_role_permission_relation
(
    relation_id   varchar(255) not null comment '关联id'
        primary key,
    permission_id varchar(255) not null comment '权限id',
    role_id       varchar(255) not null comment '角色id',
    create_by_id  varchar(255) not null comment '创建该关联关系的人的userId',
    create_date   datetime     not null comment '该关联的创建时间',
    constraint wind_role_permission_relation_relation_id_uindex
        unique (relation_id)
)
    comment '用户角色权限关联表';

create table wind_user
(
    user_id          varchar(255)              not null comment '用户主键'
        primary key,
    user_level       int default 0             not null comment '用户等级',
    user_status      int default 0             not null comment '用户状态 0 - 未激活 1 - 正常 2 - 已删除',
    user_nick_name   varchar(300) charset utf8 null comment '用户昵称',
    user_sex         int default 0             not null comment '0 - 保密 1 - 男 2 - 女 ',
    user_sex_text    varchar(255)              null comment '用户性别中文解释',
    user_avatar      varchar(300)              null comment '用户头像地址',
    create_by_id     varchar(255)              null comment '创建人的userId',
    create_date      datetime                  null comment '创建时间',
    update_by_id     varchar(255)              null comment '最近一次更新用户信息的人的userid',
    update_date      datetime                  null comment '最近一次更新用户信息的时间',
    user_email       varchar(255)              null comment '用户邮箱',
    user_mobile      varchar(20)               null comment '用户手机号',
    user_real_name   varchar(600) charset utf8 null comment '用户的真实姓名',
    user_status_text varchar(600)              not null comment '用户状态中文解释',
    constraint wind_user_user_email_uindex
        unique (user_email),
    constraint wind_user_user_id_uindex
        unique (user_id),
    constraint wind_user_user_mobile_uindex
        unique (user_mobile),
    constraint wind_user_user_nick_name_uindex
        unique (user_nick_name)
)
    comment '风旅用户表';

create table wind_user_department_relation
(
    relation_id   varchar(255) not null comment '关联id'
        primary key,
    user_id       varchar(255) not null comment '用户id',
    department_id varchar(255) not null comment '部门id',
    create_by_id  varchar(255) not null comment '创建该关联的人的userId',
    rcreate_date  datetime     not null comment '创建时间',
    constraint wind_user_department_relation_relation_id_uindex
        unique (relation_id)
)
    comment '风旅用户部门关联表';

create table wind_user_group
(
    user_group_id              varchar(255)              not null comment '用户组的id'
        primary key,
    user_group_name            varchar(255)              not null comment '用户组名称',
    user_group_name_text       varchar(600) charset utf8 not null comment '用户组中文名称',
    user_group_parent_id       varchar(255)              not null comment '父级用户组id',
    user_group_parent_ancestor varchar(600)              not null comment '父级用户层级',
    user_group_status          int                       not null comment '用户组状态',
    user_group_status_text     varchar(255)              not null comment '用户组状态中文解释',
    create_by_id               varchar(255)              not null comment '创建该用户组的人的userId',
    create_date                datetime                  not null comment '创建该用户组的时间',
    update_by_id               varchar(255)              not null comment '最近一次更新该用户组的人的userId',
    update_date                varchar(255)              not null comment '最近一次更新该用户组的时间',
    constraint user_group_name
        unique (user_group_name),
    constraint wind_user_group_user_group_id_uindex
        unique (user_group_id)
)
    comment '用户组表(暂时不用)';

create table wind_user_group_role_relation
(
    relation_id   varchar(255) not null comment '主键'
        primary key,
    user_group_id varchar(255) not null comment '用户组id',
    role_id       varchar(255) not null comment '角色id',
    create_by_id  varchar(255) not null comment '关联创建人的userId',
    create_date   datetime     not null comment '关联创建时间',
    constraint wind_user_group_role_relation_relation_id_uindex
        unique (relation_id)
)
    comment '用户组角色关联表';

create table wind_user_group_user_relation
(
    relation_id   varchar(255) not null comment '关联id'
        primary key,
    user_id       varchar(255) not null comment '用户id',
    user_group_id varchar(255) not null comment '用户组id',
    create_by_id  varchar(255) not null comment '创建该关联的人的user_id',
    create_date   datetime     not null comment '创建该关联的时间',
    constraint wind_user_group_user_relation_relation_id_uindex
        unique (relation_id)
)
    comment '用户与用户组关联表';

create table wind_user_role_relation
(
    user_id      varchar(255) not null comment '用户id',
    role_id      varchar(255) not null comment '角色id',
    relation_id  varchar(255) not null comment '关联id'
        primary key,
    create_by_id varchar(255) not null comment '创建关联信息的创建人的userId',
    create_date  datetime     not null comment ' 创建关联信息的时间',
    constraint wind_user_role_relation_relation_id_uindex
        unique (relation_id)
)
    comment '风旅角色用户关联信息表';

create table wx_account
(
    account_id    varchar(255)              not null comment '生成账户id'
        primary key,
    union_id      varchar(255)              null comment '微信的union_id',
    open_id       varchar(255)              null comment '微信的open_id',
    wx_nick_name  varchar(600) charset utf8 null comment '微信用户昵称',
    wx_avatar     varchar(600)              null comment '微信用户头像地址',
    register_ip   varchar(60)               not null comment '注册ip',
    login_ip      varchar(60)               not null comment '最近一次登录的ip地址',
    register_date datetime                  not null comment '注册时间',
    login_date    datetime                  null comment '最近一次登录的时间',
    token         varchar(255)              not null comment '微信用户最近一次登录持有的token',
    constraint wx_account_account_id_uindex
        unique (account_id),
    constraint wx_account_token_uindex
        unique (token),
    constraint wx_account_union_id_uindex
        unique (union_id)
)
    comment '微信注册用户';

