#SpringMVC
SpringMVC 小例子

--DataBase:
-- Table "tb_user" DDL

CREATE TABLE `tb_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(200) NOT NULL COMMENT '用户名称',
  `passwd` varchar(200) NOT NULL COMMENT '密码',
  `email` varchar(200) DEFAULT NULL COMMENT '箱邮地址',
  `bak` varchar(255) DEFAULT NULL COMMENT '注备',
  `createtime` varchar(50) NOT NULL DEFAULT '' COMMENT '创建时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
