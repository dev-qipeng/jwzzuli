/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : lqmsql
Target Host     : localhost:3306
Target Database : lqmsql
Date: 2017-04-14 20:32:08
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '001', '001');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `cs_id` int(11) NOT NULL AUTO_INCREMENT,
  `cName` varchar(60) DEFAULT NULL,
  `cmark` varchar(50) DEFAULT NULL,
  `cour_time` varchar(50) DEFAULT NULL,
  `room_id` varchar(50) DEFAULT NULL,
  `tea_id` varchar(50) DEFAULT NULL,
  `chooseMax` int(11) DEFAULT NULL,
  `chooseCurNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`cs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '语文', '6', '周一第一大节', '三角楼304', '1', '100', '50');
INSERT INTO `classes` VALUES ('2', '数学', '6', '周一第二大节', '三角楼408', '2', '80', '60');
INSERT INTO `classes` VALUES ('3', '计算机网络', '4', '周一第三大节', '三角楼103', '1', '100', '60');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `score` int(11) DEFAULT NULL,
  `st_id` int(11) DEFAULT NULL,
  `cs_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`score_id`),
  KEY `FKswak08i9mldyxedvi3e29qk5k` (`st_id`),
  KEY `FKiifqiashhnqq7iu6ab3726bi6` (`cs_id`),
  CONSTRAINT `FKiifqiashhnqq7iu6ab3726bi6` FOREIGN KEY (`cs_id`) REFERENCES `classes` (`cs_id`),
  CONSTRAINT `FKswak08i9mldyxedvi3e29qk5k` FOREIGN KEY (`st_id`) REFERENCES `student` (`st_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('16', '80', '1', '1');
INSERT INTO `score` VALUES ('17', '80', '1', '2');
INSERT INTO `score` VALUES ('18', '80', '2', '1');
INSERT INTO `score` VALUES ('20', '80', '2', '3');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `st_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `sno` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `mark` varchar(50) DEFAULT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `department` varchar(30) DEFAULT NULL,
  `jiguan` varchar(60) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `image` varchar(100) DEFAULT NULL,
  `maxClasses` int(11) DEFAULT NULL,
  PRIMARY KEY (`st_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '001', '001', '1364928636@sina.com', '15639019210', '80', 'f', 'software', 'henan', '001', '3f72115cd7707804c48c8c77015f49b9.jpg', '1');
INSERT INTO `student` VALUES ('2', '002', '002', '1564189592@qq.com', '17737216829', '50', '女', 'jitong', 'beijing', '002', '2_副本.jpg', '2');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `tel` varchar(50) NOT NULL,
  `tea_id` varchar(50) NOT NULL,
  `tpassword` varchar(50) NOT NULL,
  `tname` varchar(50) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '22', '13513', '1315', '001', '001', 'wo');
