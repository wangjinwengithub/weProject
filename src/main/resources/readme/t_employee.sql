/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : zhengzhou

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2019-04-09 17:47:50
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_employee`
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee` (
  `EMPLOYEE_ID` int(11) NOT NULL,
  `NAME` varchar(26) NOT NULL,
  `SEX` int(11) DEFAULT '1' COMMENT '1男 2女',
  `IDCARD` varchar(20) NOT NULL,
  `PHONE` varchar(20) DEFAULT NULL COMMENT '手机号',
  `DEPARTMENT` int(11) DEFAULT NULL COMMENT '部门',
  `EMPLOYEE_NUMBER` varchar(30) DEFAULT NULL COMMENT '员工编号',
  `CREATE_TIME` datetime DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL COMMENT '1.在职 2离职'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES ('1', '张三', '1', '532012411542156254', '14523698745', '1', '22', '2019-04-09 17:22:33', '1');
