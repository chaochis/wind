create table wind_user
(
    user_id            varchar(255)  not null comment '用户主键',
    user_name          nvarchar(255) not null comment '用户名',
    user_email         varchar(64)   null comment '用户邮箱',
    user_mobile        varchar(20)   not null comment '用户手机号',
    user_password      varchar(20)   not null comment '用户的密码',
    user_password_salt varchar(255)  not null comment '用户密码盐值',
    user_level         int default 0 not null comment '用户等级',
    user_status        int default 0 not null comment '用户状态 0 - 未激活 1 - 正常 2 - 已删除',
    user_type          int default 0 not null comment '用户类型 0 - wind用户 1 - 微信用户',
    constraint wind_user_pk
        primary key (user_id)
)
    comment '风旅用户表';

create unique index wind_user_user_id_uindex
    on wind_user (user_id);