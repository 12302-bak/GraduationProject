/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : graduation_project

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-05-26 10:20:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `a` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `passwd` varchar(50) NOT NULL,
  `createtime` datetime NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('0000000001', 'xhs12302', 'xhs12302', '2018-05-17 14:36:31', 'this');
INSERT INTO `user` VALUES ('0000000002', 'Elizabeth', 'xhs12302', '2018-05-17 14:36:54', 'IS');
INSERT INTO `user` VALUES ('0000000003', 'admin', 'xhs12302', '2018-05-17 14:37:18', 'My first graduationProject');
