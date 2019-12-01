/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : studytest18newscourse4vipchart2kaoyan

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2019-04-19 22:41:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_choose
-- ----------------------------
DROP TABLE IF EXISTS `t_choose`;
CREATE TABLE `t_choose` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) DEFAULT NULL,
  `daan` varchar(500) DEFAULT NULL,
  `opa` varchar(255) DEFAULT NULL,
  `opb` varchar(255) DEFAULT NULL,
  `opc` varchar(255) DEFAULT NULL,
  `opd` varchar(255) DEFAULT NULL,
  `fenxi` varchar(2000) DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  `img` varchar(2000) DEFAULT NULL,
  `leixing` int(11) DEFAULT NULL,
  `rc` int(11) DEFAULT NULL,
  `wc` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_choose
-- ----------------------------

-- ----------------------------
-- Table structure for t_pdt
-- ----------------------------
DROP TABLE IF EXISTS `t_pdt`;
CREATE TABLE `t_pdt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `daan` varchar(500) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `leixing` int(11) DEFAULT NULL,
  `typeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pdt
-- ----------------------------

-- ----------------------------
-- Table structure for t_tousu
-- ----------------------------
DROP TABLE IF EXISTS `t_tousu`;
CREATE TABLE `t_tousu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` varchar(10) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `uid` varchar(10) DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  `ndate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_tousu
-- ----------------------------

-- ----------------------------
-- Table structure for wct_address
-- ----------------------------
DROP TABLE IF EXISTS `wct_address`;
CREATE TABLE `wct_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_address
-- ----------------------------

-- ----------------------------
-- Table structure for wct_bill
-- ----------------------------
DROP TABLE IF EXISTS `wct_bill`;
CREATE TABLE `wct_bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gids` varchar(100) DEFAULT NULL,
  `price` varchar(100) DEFAULT NULL,
  `user` varchar(100) DEFAULT NULL,
  `uid` varchar(100) DEFAULT NULL,
  `shop` varchar(100) DEFAULT NULL,
  `bill` varchar(2000) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `ndate` varchar(255) DEFAULT NULL,
  `total` varchar(255) DEFAULT NULL,
  `way` varchar(50) DEFAULT NULL,
  `gnames` varchar(500) DEFAULT NULL,
  `sid` varchar(10) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `note` varchar(200) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `statecn` varchar(50) DEFAULT NULL,
  `cuidan` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_bill
-- ----------------------------

-- ----------------------------
-- Table structure for wct_dingzuo
-- ----------------------------
DROP TABLE IF EXISTS `wct_dingzuo`;
CREATE TABLE `wct_dingzuo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(200) DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  `renshu` varchar(20) DEFAULT NULL,
  `xingming` varchar(200) DEFAULT NULL,
  `shouji` varchar(200) DEFAULT NULL,
  `shijian` varchar(200) DEFAULT NULL,
  `todate` varchar(200) DEFAULT NULL,
  `beizhu` varchar(600) DEFAULT NULL,
  `shopid` varchar(200) DEFAULT NULL,
  `shopname` varchar(200) DEFAULT NULL,
  `ndate` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_dingzuo
-- ----------------------------

-- ----------------------------
-- Table structure for wct_good
-- ----------------------------
DROP TABLE IF EXISTS `wct_good`;
CREATE TABLE `wct_good` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(100) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `jifen` varchar(10) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `img` varchar(500) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `typeid` varchar(10) DEFAULT NULL,
  `xiaoliang` int(11) DEFAULT NULL,
  `ownid` varchar(10) DEFAULT NULL,
  `sid` varchar(10) DEFAULT NULL,
  `shop` varchar(50) DEFAULT NULL,
  `mcount` varchar(50) DEFAULT NULL,
  `saleType` varchar(50) DEFAULT NULL,
  `sale` varchar(20) DEFAULT NULL,
  `shouye` int(11) DEFAULT NULL,
  `zan` int(11) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `btype` varchar(50) DEFAULT NULL,
  `attach` varchar(50) DEFAULT NULL,
  `dtype` int(11) DEFAULT NULL,
  `tempf` int(11) DEFAULT NULL,
  `tempt` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_good
-- ----------------------------
INSERT INTO `wct_good` VALUES ('1', '高数方差资料', null, null, '这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍这里是资料的详细说明介绍', null, '7852a29c-1209-4401-8b08-af8596e3.jpg', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, '70eb1297-c36f-46e6-b416-02b9413d.mp4', null, null, null);
INSERT INTO `wct_good` VALUES ('2', '函数资料', null, null, '这里是资料的文字描述这里是资料的文字描述这里是资料的文字描述这里是资料的文字描述这里是资料的文字描述这里是资料的文字描述这里是资料的文字描述这里是资料的文字描述这里是资料的文字描述这里是资料的文字描述这里是资料的文字描述', null, 'e894ebff-c9f7-4c80-b05e-d4db051f.jpg', '0', '1', null, null, null, null, null, null, null, null, null, null, null, null, '2ef07edc-7056-425d-97a7-1c2d4475.txt', null, null, null);
INSERT INTO `wct_good` VALUES ('3', '测试资料2', null, null, '这里是资料的详细文字描述', null, '6c2166b1-36b0-44bf-9804-2df443cd.jpg', '0', '2', null, null, null, null, null, null, null, null, null, null, null, null, '7abd9159-3b44-492a-a1c6-9454c6e4.txt', null, null, null);

-- ----------------------------
-- Table structure for wct_line
-- ----------------------------
DROP TABLE IF EXISTS `wct_line`;
CREATE TABLE `wct_line` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_line
-- ----------------------------

-- ----------------------------
-- Table structure for wct_notice
-- ----------------------------
DROP TABLE IF EXISTS `wct_notice`;
CREATE TABLE `wct_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `ndate` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `img` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_notice
-- ----------------------------
INSERT INTO `wct_notice` VALUES ('1', '考研资讯', '这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容这里是资讯的文字内容', '2019-04-18 11:09:37', null, '756cf22f-d4e9-4035-a918-8d29ba56.gif');
INSERT INTO `wct_notice` VALUES ('2', '考研资讯22', '这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容这里资讯内容', '2019-04-18 11:26:53', null, 'edb648fc-a8df-43e7-9e46-d3255bce.gif');

-- ----------------------------
-- Table structure for wct_posts
-- ----------------------------
DROP TABLE IF EXISTS `wct_posts`;
CREATE TABLE `wct_posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `uid` varchar(10) DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  `ndate` varchar(50) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `zan` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_posts
-- ----------------------------
INSERT INTO `wct_posts` VALUES ('1', '好烦呀', '这里是要讨论的内容', '1', 'admin', '2019-04-18 11:21:16', null, '情感', '1');
INSERT INTO `wct_posts` VALUES ('2', '这个怎么做', '这里是交流美容', '2', '小凤', '2019-04-18 11:30:25', '1a12b950-901b-4ba4-91f0-1ccbc64826d8.jpg', '学习', null);

-- ----------------------------
-- Table structure for wct_replay
-- ----------------------------
DROP TABLE IF EXISTS `wct_replay`;
CREATE TABLE `wct_replay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pid` varchar(10) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `uid` varchar(10) DEFAULT NULL,
  `username` varchar(200) DEFAULT NULL,
  `ndate` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_replay
-- ----------------------------
INSERT INTO `wct_replay` VALUES ('1', '2', '这里可以对资料回复', '2', '小凤', '2019-04-18 11:29:34', null);
INSERT INTO `wct_replay` VALUES ('2', '1', '不要烦', '2', '小凤', '2019-04-18 11:29:50', null);

-- ----------------------------
-- Table structure for wct_rizhi
-- ----------------------------
DROP TABLE IF EXISTS `wct_rizhi`;
CREATE TABLE `wct_rizhi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `uid` varchar(100) DEFAULT NULL,
  `ndate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_rizhi
-- ----------------------------
INSERT INTO `wct_rizhi` VALUES ('1', '高数方差资料', 'admin', '1', '2019-04-18 11:14:43');
INSERT INTO `wct_rizhi` VALUES ('2', '高数方差资料', 'admin', '1', '2019-04-18 11:15:59');
INSERT INTO `wct_rizhi` VALUES ('3', '函数资料', 'admin', '1', '2019-04-18 11:16:02');
INSERT INTO `wct_rizhi` VALUES ('4', '函数资料', 'admin', '1', '2019-04-18 11:17:52');
INSERT INTO `wct_rizhi` VALUES ('5', '函数资料', 'admin', '1', '2019-04-18 11:18:09');
INSERT INTO `wct_rizhi` VALUES ('6', '函数资料', 'admin', '1', '2019-04-18 11:19:21');
INSERT INTO `wct_rizhi` VALUES ('7', '高数方差资料', '小凤', '2', '2019-04-18 11:29:00');
INSERT INTO `wct_rizhi` VALUES ('8', '函数资料', '小凤', '2', '2019-04-18 11:29:11');

-- ----------------------------
-- Table structure for wct_room
-- ----------------------------
DROP TABLE IF EXISTS `wct_room`;
CREATE TABLE `wct_room` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_room
-- ----------------------------

-- ----------------------------
-- Table structure for wct_shijuan
-- ----------------------------
DROP TABLE IF EXISTS `wct_shijuan`;
CREATE TABLE `wct_shijuan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) DEFAULT NULL,
  `ownid` varchar(10) DEFAULT NULL,
  `cids` varchar(500) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_shijuan
-- ----------------------------

-- ----------------------------
-- Table structure for wct_shop
-- ----------------------------
DROP TABLE IF EXISTS `wct_shop`;
CREATE TABLE `wct_shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(100) DEFAULT NULL,
  `img` varchar(500) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `address` varchar(500) DEFAULT NULL,
  `longitude` varchar(100) DEFAULT NULL,
  `latitude` varchar(100) DEFAULT NULL,
  `tel` varchar(100) DEFAULT NULL,
  `ownid` varchar(10) DEFAULT NULL,
  `passwd` varchar(50) DEFAULT NULL,
  `price` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_shop
-- ----------------------------

-- ----------------------------
-- Table structure for wct_type
-- ----------------------------
DROP TABLE IF EXISTS `wct_type`;
CREATE TABLE `wct_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) DEFAULT NULL,
  `ownid` varchar(10) DEFAULT NULL,
  `img` varchar(500) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `totalh` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_type
-- ----------------------------
INSERT INTO `wct_type` VALUES ('1', '高数', null, null, null, null);
INSERT INTO `wct_type` VALUES ('2', '英语', null, null, null, null);
INSERT INTO `wct_type` VALUES ('3', '政治', null, null, null, null);
INSERT INTO `wct_type` VALUES ('4', '计算机', null, null, null, null);

-- ----------------------------
-- Table structure for wct_user
-- ----------------------------
DROP TABLE IF EXISTS `wct_user`;
CREATE TABLE `wct_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `passwd` varchar(50) DEFAULT NULL,
  `roletype` varchar(50) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `qq` varchar(20) DEFAULT NULL,
  `wechat` varchar(50) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `birth` varchar(20) DEFAULT NULL,
  `img` varchar(200) DEFAULT NULL,
  `sid` varchar(200) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `statecn` varchar(50) DEFAULT NULL,
  `fname` varchar(50) DEFAULT NULL,
  `clientId` varchar(200) DEFAULT NULL,
  `favs` varchar(200) DEFAULT NULL,
  `cuotis` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_user
-- ----------------------------
INSERT INTO `wct_user` VALUES ('1', 'admin', 'admin', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `wct_user` VALUES ('2', '小凤', '111111', '2', null, '15123385885', null, null, '男', null, 'f2b34524-2f9b-4a40-9236-bdc7062ab615.jpg', null, '西南大学', null, '凤姐', null, null, null);

-- ----------------------------
-- Table structure for wct_video
-- ----------------------------
DROP TABLE IF EXISTS `wct_video`;
CREATE TABLE `wct_video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `note` varchar(2000) DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `video` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_video
-- ----------------------------

-- ----------------------------
-- Table structure for wct_vip
-- ----------------------------
DROP TABLE IF EXISTS `wct_vip`;
CREATE TABLE `wct_vip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qq` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `vname` varchar(255) DEFAULT NULL,
  `wname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wct_vip
-- ----------------------------
