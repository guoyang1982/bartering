/*
Navicat MySQL Data Transfer

Source Server         : Email
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : bartering

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2013-08-06 17:15:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ad_type`
-- ----------------------------
DROP TABLE IF EXISTS `ad_type`;
CREATE TABLE `ad_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `priority` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of ad_type
-- ----------------------------

-- ----------------------------
-- Table structure for `barter_city`
-- ----------------------------
DROP TABLE IF EXISTS `barter_city`;
CREATE TABLE `barter_city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cate_rela` varchar(255) DEFAULT NULL,
  `cate_type` int(11) DEFAULT NULL,
  `ifchilden` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `e_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of barter_city
-- ----------------------------
INSERT INTO `barter_city` VALUES ('1', null, '0', 'y', '北京', 'beijing');
INSERT INTO `barter_city` VALUES ('2', '|1|', '1', 'y', '海淀', 'haidian');
INSERT INTO `barter_city` VALUES ('3', '|1|', '1', 'y', '朝阳', 'chaoyang');
INSERT INTO `barter_city` VALUES ('4', '|1|', '1', 'y', '东城', 'dongcheng');
INSERT INTO `barter_city` VALUES ('5', '|1|', '1', 'y', '西城', 'xicheng');
INSERT INTO `barter_city` VALUES ('6', '|1|', '1', 'y', '崇文', 'chongwen');
INSERT INTO `barter_city` VALUES ('7', '|1|', '1', 'y', '宣武', 'xuanwu');
INSERT INTO `barter_city` VALUES ('8', '|1|', '1', 'y', '丰台', 'fengtai');
INSERT INTO `barter_city` VALUES ('9', '|1|', '1', 'y', '石景山', 'shijingshan');
INSERT INTO `barter_city` VALUES ('10', '|1|', '1', 'y', '昌平', 'changping');
INSERT INTO `barter_city` VALUES ('11', '|1|', '1', 'y', '通州', 'tongzhou');
INSERT INTO `barter_city` VALUES ('12', '|1|', '1', 'y', '大兴', 'daxing');
INSERT INTO `barter_city` VALUES ('13', '|1|', '1', 'y', '顺义', 'shunyi');
INSERT INTO `barter_city` VALUES ('14', '|1|', '1', 'y', '房山', 'fangshan');
INSERT INTO `barter_city` VALUES ('15', '|1|', '1', 'y', '密云', 'miyun');
INSERT INTO `barter_city` VALUES ('18', '|1|', '1', 'y', '平谷', 'pinggu');
INSERT INTO `barter_city` VALUES ('20', '|1|', '1', 'y', '燕郊', 'yanjiao');
INSERT INTO `barter_city` VALUES ('21', '|1|2|', '2', 'n', '清河', 'qinghe');
INSERT INTO `barter_city` VALUES ('22', '|1|2|', '2', 'n', '小营', 'xiaoying');
INSERT INTO `barter_city` VALUES ('23', '|1|2|', '2', 'n', '西三旗', 'xisanqi');
INSERT INTO `barter_city` VALUES ('24', '|1|2|', '2', 'n', '西二旗', 'xierqi');
INSERT INTO `barter_city` VALUES ('25', '|1|2|', '2', 'n', '上地', 'shangdi');
INSERT INTO `barter_city` VALUES ('26', '|1|3|', '3', 'n', 'ff', 'ff');
INSERT INTO `barter_city` VALUES ('27', '|1|3|', '3', 'n', 'nn', 'nn');

-- ----------------------------
-- Table structure for `barter_pic`
-- ----------------------------
DROP TABLE IF EXISTS `barter_pic`;
CREATE TABLE `barter_pic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ifcover` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `thing_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9F7100F98CF408A7` (`thing_id`),
  CONSTRAINT `FK9F7100F98CF408A7` FOREIGN KEY (`thing_id`) REFERENCES `barter_things` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of barter_pic
-- ----------------------------
INSERT INTO `barter_pic` VALUES ('1', 'false', 'Chrysanthemum.jpg', '4');
INSERT INTO `barter_pic` VALUES ('2', 'false', 'Hydrangeas.jpg', '4');
INSERT INTO `barter_pic` VALUES ('3', 'true', 'aaa.jpg', '4');
INSERT INTO `barter_pic` VALUES ('4', 'true', 'Lighthouse.jpg', '5');
INSERT INTO `barter_pic` VALUES ('5', 'false', 'Tulips.jpg', '5');
INSERT INTO `barter_pic` VALUES ('6', 'false', 'Penguins.jpg', '5');
INSERT INTO `barter_pic` VALUES ('7', 'true', 'aaa.jpg', '6');
INSERT INTO `barter_pic` VALUES ('8', 'true', 'aaa.jpg', '7');
INSERT INTO `barter_pic` VALUES ('9', 'true', 'aaa.jpg', '8');

-- ----------------------------
-- Table structure for `barter_role`
-- ----------------------------
DROP TABLE IF EXISTS `barter_role`;
CREATE TABLE `barter_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of barter_role
-- ----------------------------

-- ----------------------------
-- Table structure for `barter_things`
-- ----------------------------
DROP TABLE IF EXISTS `barter_things`;
CREATE TABLE `barter_things` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city_id` bigint(20) DEFAULT NULL,
  `t_condition` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `t_des` varchar(255) DEFAULT NULL,
  `t_have` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `t_want` varchar(255) DEFAULT NULL,
  `people_name` varchar(120) DEFAULT NULL,
  `people_tel` varchar(120) DEFAULT NULL,
  `people_qq` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of barter_things
-- ----------------------------
INSERT INTO `barter_things` VALUES ('1', '0', null, null, '123', '笔记本', '1222', '0', '电脑', '23', '123', '12');
INSERT INTO `barter_things` VALUES ('2', '0', null, null, '123', '笔记本', '1222', '0', '电脑', '23', '123', '12');
INSERT INTO `barter_things` VALUES ('3', '0', null, null, '123123', '过广告', '123', '0', '阿尔瓦发', '郭阳', '132', '123');
INSERT INTO `barter_things` VALUES ('4', '0', null, null, '阿道夫', '撒地方', '123', '0', '阿斯蒂芬', '321', '123', '123');
INSERT INTO `barter_things` VALUES ('5', '24', null, '2013-08-05 18:50:49', '啊沙发', '撒地方', '123213', '7', '撒地方', '郭阳', '123', '123');
INSERT INTO `barter_things` VALUES ('6', '24', null, '2013-08-06 11:21:20', '爱的色放', '汽车', '123456', '7', '钱', '郭阳', '13671255430', '5264332');
INSERT INTO `barter_things` VALUES ('7', '24', null, '2013-08-06 15:20:11', '爱的色放', '汽车', '123456', '7', '钱', '郭阳', '13671255430', '5264332');
INSERT INTO `barter_things` VALUES ('8', '24', null, '2013-08-06 15:20:16', '爱的色放', '汽车', '123456', '7', '钱', '郭阳', '13671255430', '5264332');

-- ----------------------------
-- Table structure for `barter_user`
-- ----------------------------
DROP TABLE IF EXISTS `barter_user`;
CREATE TABLE `barter_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `createTime` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_passpowder` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of barter_user
-- ----------------------------
INSERT INTO `barter_user` VALUES ('1', null, null, null, null, '0', null, null, ', guoyag', ', 123');
INSERT INTO `barter_user` VALUES ('2', null, null, null, null, '0', null, null, ', gy', ', `132');
INSERT INTO `barter_user` VALUES ('3', null, null, null, null, '0', null, null, ', gy', ', `132');
INSERT INTO `barter_user` VALUES ('4', null, null, null, null, '0', null, null, ', guoyang', ', 123');
INSERT INTO `barter_user` VALUES ('5', null, null, null, null, '0', null, null, ', guoyang', ', 123');
INSERT INTO `barter_user` VALUES ('6', null, null, null, null, '0', null, null, ', guoyang', ', 2');
INSERT INTO `barter_user` VALUES ('7', null, null, null, null, '0', null, null, 'guoyang', '123');
INSERT INTO `barter_user` VALUES ('8', null, null, null, null, '0', null, null, 'guoyang', '123');
INSERT INTO `barter_user` VALUES ('9', null, null, null, null, '0', null, null, 'guoyang', '123');
