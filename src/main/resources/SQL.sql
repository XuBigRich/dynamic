-- user库的脚本
CREATE DATABASE user
CHARACTER SET utf8
COLLATE utf8_general_ci;
USE user
CREATE TABLE `user` (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  username varchar(10) DEFAULT NULL COMMENT '姓名',
  password  varchar(10) DEFAULT NULL COMMENT '密码',
  avatar_id int(2) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

INSERT INTO user VALUE(NULL,'许鸿志','123123',1);
INSERT INTO user VALUE(NULL,'许大富','123123',2);

CREATE TABLE `base` (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  name varchar(10) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT charset=utf8;

INSERT INTO base VALUE(NULL,'许鸿志');

-- role库的脚本
CREATE DATABASE role
CHARACTER SET utf8
COLLATE utf8_general_ci;

USE role
CREATE TABLE user_role (
  user_id int(11) DEFAULT NULL,
  role_id  int(11)  DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT charset=utf8;

INSERT INTO user_role VALUE(1,1);
INSERT INTO user_role VALUE(1,2);
INSERT INTO user_role VALUE(1,3);
INSERT INTO user_role VALUE(2,1);
INSERT INTO user_role VALUE(2,3);

USE role
CREATE TABLE  `role` (
   id int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
    role_name  varchar(10) DEFAULT NULL COMMENT '角色名称',
    role_key varchar(10) DEFAULT NULL COMMENT '角色别称',
    role_sort int(11) COMMENT  '权限排序',
  status  tinyint(4) DEFAULT 1,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT charset=UTF8;

INSERT INTO `role` VALUE(NULL,'管理员','GLY',1,1);
INSERT INTO `role` VALUE(NULL,'超级管理员','SJGLY',1,1);
INSERT INTO `role` VALUE(NULL,'员工','YG',1,1);

CREATE TABLE `base` (
  id int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  name varchar(10) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT charset=utf8;

INSERT INTO base VALUE(NULL,'许大富');