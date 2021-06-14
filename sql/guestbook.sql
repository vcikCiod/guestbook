/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : guestbook

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-11-22 01:05:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `createdatetime` datetime DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('18', 'fdfs', 'fsdfdsfd', '2017-05-07 22:24:32', '4', null);
INSERT INTO `message` VALUES ('19', '测试1', '测试1', '2017-05-07 22:29:29', '5', null);
INSERT INTO `message` VALUES ('20', '测试5', '测试5', '2017-05-07 22:33:55', '20', null);

-- ----------------------------
-- Table structure for trole
-- ----------------------------
DROP TABLE IF EXISTS `trole`;
CREATE TABLE `trole` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trole
-- ----------------------------
INSERT INTO `trole` VALUES ('1', 'admin');
INSERT INTO `trole` VALUES ('2', 'register');

-- ----------------------------
-- Table structure for tuser
-- ----------------------------
DROP TABLE IF EXISTS `tuser`;
CREATE TABLE `tuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuser
-- ----------------------------
INSERT INTO `tuser` VALUES ('3', 'tom', '1234', '1');
INSERT INTO `tuser` VALUES ('4', 'mike', '1234', '2');
INSERT INTO `tuser` VALUES ('5', 'rose', '1234', '2');
INSERT INTO `tuser` VALUES ('20', 'alice', '1234', '2');
INSERT INTO `tuser` VALUES ('21', '11', '11', '1');
INSERT INTO `tuser` VALUES ('22', '张三', '123456', '1');
