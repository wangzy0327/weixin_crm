-- 数据库初始化脚本
-- 创建数据库
DROP DATABASE weixin_crm;
CREATE DATABASE weixin_crm;
-- 使用数据库
use weixin_crm;
CREATE TABLE user(
  `user_id` INT NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` VARCHAR (20) NOT NULL COMMENT '用户姓名',
  PRIMARY KEY (user_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='用户表';

INSERT INTO
user(user_name)
VALUES
('黄大烨'),
('黄小烨'),
('黄中烨');

CREATE TABLE  `t_token`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `access_token` varchar(1024) NOT NULL,
  `expires_in` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET=utf8 COMMENT='token表'