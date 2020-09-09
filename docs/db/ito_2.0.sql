/*
Navicat MySQL Data Transfer

Source Server         : ito_test
Source Server Version : 50624
Source Host           : 10.56.203.74:3306
Source Database       : ito_2.0

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-09-30 15:27:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for app_authority
-- ----------------------------
DROP TABLE IF EXISTS `app_authority`;
CREATE TABLE `app_authority` (
  `authority_id` varchar(20) NOT NULL  COMMENT '主键',
  `creator_id` varchar(20) NOT NULL COMMENT '@desc 创建人id',
  `gmt_create` datetime NOT NULL COMMENT '@desc 创建时间',
  `modifier` varchar(20) DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '@desc   是否删除',
  `authority_name` varchar(20) DEFAULT NULL COMMENT '@desc   权限名称',
  `page_name` varchar(30) DEFAULT NULL COMMENT '@desc   页面权限',
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限配置表';

-- ----------------------------
-- Records of app_authority
-- ----------------------------
INSERT INTO `app_authority` VALUES ('1', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'A');
INSERT INTO `app_authority` VALUES ('2', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'A');
INSERT INTO `app_authority` VALUES ('3', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'B');
INSERT INTO `app_authority` VALUES ('4', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'B');
INSERT INTO `app_authority` VALUES ('5', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'C');
INSERT INTO `app_authority` VALUES ('6', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'C');
INSERT INTO `app_authority` VALUES ('7', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'D');
INSERT INTO `app_authority` VALUES ('8', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'D');
INSERT INTO `app_authority` VALUES ('9', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'E');
INSERT INTO `app_authority` VALUES ('10', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'E');
INSERT INTO `app_authority` VALUES ('11', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'F');
INSERT INTO `app_authority` VALUES ('12', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'F');
INSERT INTO `app_authority` VALUES ('13', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'G');
INSERT INTO `app_authority` VALUES ('14', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'G');
INSERT INTO `app_authority` VALUES ('15', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'H');
INSERT INTO `app_authority` VALUES ('16', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'H');
INSERT INTO `app_authority` VALUES ('17', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'I');
INSERT INTO `app_authority` VALUES ('18', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'I');
INSERT INTO `app_authority` VALUES ('19', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'J');
INSERT INTO `app_authority` VALUES ('20', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'J');
INSERT INTO `app_authority` VALUES ('21', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'K');
INSERT INTO `app_authority` VALUES ('22', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'K');
INSERT INTO `app_authority` VALUES ('23', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'L');
INSERT INTO `app_authority` VALUES ('24', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'L');
INSERT INTO `app_authority` VALUES ('25', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'M');
INSERT INTO `app_authority` VALUES ('26', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'M');
INSERT INTO `app_authority` VALUES ('27', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'N');
INSERT INTO `app_authority` VALUES ('28', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'N');
INSERT INTO `app_authority` VALUES ('29', '1', '2016-09-23 10:51:19', null, null, 'n', 'a', 'O');
INSERT INTO `app_authority` VALUES ('30', '1', '2016-09-23 10:51:19', null, null, 'n', 'b', 'O');

-- ----------------------------
-- Table structure for app_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `app_dictionary`;
CREATE TABLE `app_dictionary` (
  `dictionary_id` varchar(20) NOT NULL  COMMENT '主键',
  `creator_id` varchar(20) NOT NULL COMMENT '创建人id',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `type_info` varchar(20) NOT NULL COMMENT '配置类型，例如：岗位，业务线。。。',
  `key_info` varchar(20) DEFAULT NULL COMMENT '字典中的键',
  `value_info` varchar(20) DEFAULT NULL COMMENT '字典中的值',
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  PRIMARY KEY (`dictionary_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='配置字典表';

-- ----------------------------
-- Records of app_dictionary
-- ----------------------------
INSERT INTO `app_dictionary` VALUES ('1', '1', '2016-09-26 11:34:34', null, null, 'department', 'techDep', '技术部', 'n');
INSERT INTO `app_dictionary` VALUES ('2', '1', '2016-09-26 11:34:34', null, null, 'department', 'resoDept ', '资源部', 'n');
INSERT INTO `app_dictionary` VALUES ('3', '1', '2016-09-26 11:34:34', null, null, 'position', 'projectManager', '项目经理', 'n');
INSERT INTO `app_dictionary` VALUES ('4', '1', '2016-09-26 11:34:34', null, null, 'position', 'resourceManager', '资源经理', 'n');
INSERT INTO `app_dictionary` VALUES ('5', '1', '2016-09-26 11:34:34', null, null, 'position', 'recruitingManager', '招聘经理', 'n');
INSERT INTO `app_dictionary` VALUES ('6', '1', '2016-09-26 11:34:34', null, null, 'position', 'recruitingConsultant', '招聘顾问', 'n');
INSERT INTO `app_dictionary` VALUES ('7', '1', '2016-09-26 11:34:34', null, null, 'position', 'deliveryManager', '交付经理', 'n');
INSERT INTO `app_dictionary` VALUES ('8', '1', '2016-09-26 11:34:34', null, null, 'busiLine', 'busiLine1', '北京阿里', 'n');
INSERT INTO `app_dictionary` VALUES ('9', '1', '2016-09-26 11:34:34', null, null, 'busiLine', 'busiLine2', '上海阿里', 'n');
INSERT INTO `app_dictionary` VALUES ('10', '1', '2016-09-26 11:34:34', null, null, 'busiLine', 'busiLine3', '解决方案', 'n');
INSERT INTO `app_dictionary` VALUES ('11', '1', '2016-09-26 11:34:34', null, null, 'busiLine', 'busiLine4', 'UED', 'n');
INSERT INTO `app_dictionary` VALUES ('12', '1', '2016-09-26 11:34:34', null, null, 'busiLine', 'busiLine5', '互联网金融', 'n');
INSERT INTO `app_dictionary` VALUES ('13', '1', '2016-09-26 11:34:34', null, null, 'busiLine', 'busiLine6', '企业服务', 'n');
INSERT INTO `app_dictionary` VALUES ('14', '1', '2016-09-26 11:34:34', null, null, 'busiLine', 'busiLine7', '创新服务', 'n');
INSERT INTO `app_dictionary` VALUES ('15', '1', '2016-09-26 11:34:34', null, null, 'busiLine', 'busiLine8', '新技术保障', 'n');
INSERT INTO `app_dictionary` VALUES ('16', '1', '2016-09-26 11:34:34', null, null, 'station', 'station1', 'java开发', 'n');
INSERT INTO `app_dictionary` VALUES ('17', '1', '2016-09-26 11:34:34', null, null, 'station', 'station2', '.net(C#)开发', 'n');
INSERT INTO `app_dictionary` VALUES ('18', '1', '2016-09-26 11:34:34', null, null, 'station', 'station3', 'Python开发', 'n');
INSERT INTO `app_dictionary` VALUES ('19', '1', '2016-09-26 11:34:34', null, null, 'station', 'station4', 'PHP开发', 'n');
INSERT INTO `app_dictionary` VALUES ('20', '1', '2016-09-26 11:34:34', null, null, 'station', 'station5', 'C/C++开发', 'n');
INSERT INTO `app_dictionary` VALUES ('21', '1', '2016-09-26 11:34:34', null, null, 'station', 'station6', '前端开发', 'n');
INSERT INTO `app_dictionary` VALUES ('22', '1', '2016-09-26 11:34:34', null, null, 'station', 'station7', '功能测试', 'n');
INSERT INTO `app_dictionary` VALUES ('23', '1', '2016-09-26 11:34:34', null, null, 'station', 'station8', '自动化测试', 'n');
INSERT INTO `app_dictionary` VALUES ('24', '1', '2016-09-26 11:34:34', null, null, 'station', 'station9', '无线测试', 'n');
INSERT INTO `app_dictionary` VALUES ('25', '1', '2016-09-26 11:34:34', null, null, 'station', 'station10', 'web测试', 'n');
INSERT INTO `app_dictionary` VALUES ('26', '1', '2016-09-26 11:34:34', null, null, 'station', 'station11', 'App测试', 'n');
INSERT INTO `app_dictionary` VALUES ('27', '1', '2016-09-26 11:34:34', null, null, 'station', 'station12', '技术支持', 'n');
INSERT INTO `app_dictionary` VALUES ('28', '1', '2016-09-26 11:34:34', null, null, 'station', 'station13', '设计师-交互', 'n');
INSERT INTO `app_dictionary` VALUES ('29', '1', '2016-09-26 11:34:34', null, null, 'station', 'station14', '设计师-视觉', 'n');
INSERT INTO `app_dictionary` VALUES ('30', '1', '2016-09-26 11:34:34', null, null, 'station', 'station15', '文档工程师', 'n');
INSERT INTO `app_dictionary` VALUES ('31', '1', '2016-09-26 11:34:34', null, null, 'station', 'station16', '架构师', 'n');
INSERT INTO `app_dictionary` VALUES ('32', '1', '2016-09-26 11:34:34', null, null, 'station', 'station17', '产品经理', 'n');
INSERT INTO `app_dictionary` VALUES ('33', '1', '2016-09-26 11:34:34', null, null, 'station', 'station18', '需求分析师', 'n');
INSERT INTO `app_dictionary` VALUES ('34', '1', '2016-09-26 11:34:34', null, null, 'station', 'station19', '项目经理', 'n');
INSERT INTO `app_dictionary` VALUES ('35', '1', '2016-09-26 11:34:34', null, null, 'techLevel', 'techLevel1', '实习生', 'n');
INSERT INTO `app_dictionary` VALUES ('36', '1', '2016-09-26 11:34:34', null, null, 'techLevel', 'techLevel2', '初级', 'n');
INSERT INTO `app_dictionary` VALUES ('37', '1', '2016-09-26 11:34:34', null, null, 'techLevel', 'techLevel3', '中级', 'n');
INSERT INTO `app_dictionary` VALUES ('38', '1', '2016-09-26 11:34:34', null, null, 'techLevel', 'techLevel4', '高级', 'n');
INSERT INTO `app_dictionary` VALUES ('39', '1', '2016-09-26 11:34:34', null, null, 'techLevel', 'techLevel5', '资深', 'n');
INSERT INTO `app_dictionary` VALUES ('41', '1', '2016-09-26 11:34:34', null, null, 'gender', 'm', '男', 'n');
INSERT INTO `app_dictionary` VALUES ('42', '1', '2016-09-26 11:34:34', null, null, 'gender', 'w', '女', 'n');
INSERT INTO `app_dictionary` VALUES ('43', '1', '2016-09-26 11:34:34', null, null, 'demandState', 'saved', '已保存', 'n');
INSERT INTO `app_dictionary` VALUES ('44', '1', '2016-09-26 11:34:34', null, null, 'demandState', 'commited', '已提交', 'n');
INSERT INTO `app_dictionary` VALUES ('45', '1', '2016-09-26 11:34:34', null, null, 'demandState', 'passed', '已通过', 'n');
INSERT INTO `app_dictionary` VALUES ('46', '1', '2016-09-26 11:34:34', null, null, 'demandState', 'voted', '已否决', 'n');
INSERT INTO `app_dictionary` VALUES ('47', '1', '2016-09-26 11:34:34', null, null, 'demandState', 'closed', '已关闭', 'n');

-- ----------------------------
-- Table structure for app_role
-- ----------------------------
DROP TABLE IF EXISTS `app_role`;
CREATE TABLE `app_role` (
  `role_id` varchar(20) NOT NULL  COMMENT '主键',
  `creator_id` varchar(20) NOT NULL COMMENT '创建人id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  `role_key` varchar(20) DEFAULT NULL COMMENT '角色的key',
  `role_value` varchar(20) DEFAULT NULL COMMENT '角色的名称',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of app_role
-- ----------------------------
INSERT INTO `app_role` VALUES ('1', '1', '2016-09-23 17:54:14', null, null, 'n', 'resourceManager', '资源经理');
INSERT INTO `app_role` VALUES ('2', '1', '2016-09-23 17:54:14', null, null, 'n', 'projectManager', '项目经理');
INSERT INTO `app_role` VALUES ('3', '1', '2016-09-23 17:54:14', null, null, 'n', 'recruitingManager', '招聘经理');
INSERT INTO `app_role` VALUES ('4', '1', '2016-09-23 17:54:14', null, null, 'n', 'recruitingConsultant', '招聘顾问');
INSERT INTO `app_role` VALUES ('5', '1', '2016-09-23 17:54:14', null, null, 'n', 'deliveryManager', '交付经理');
INSERT INTO `app_role` VALUES ('6', '1', '2016-09-23 17:54:14', null, null, 'n', 'systemAdministrator', '系统管理员');

-- ----------------------------
-- Table structure for app_role_authority
-- ----------------------------
DROP TABLE IF EXISTS `app_role_authority`;
CREATE TABLE `app_role_authority` (
  `role_authority_id` varchar(20) NOT NULL  COMMENT '主键',
  `role_id` varchar(20) NOT NULL COMMENT '角色id',
  `authority_id` varchar(20) NOT NULL COMMENT '权限第id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `creator_id` varchar(20) NOT NULL COMMENT '创建人id',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_authority_id`),
  KEY `FK_ROLEAUTHORITY_REFRENCE_ROLE` (`role_id`),
  KEY `FK_ROLEAUTHORITY_REFRENCE_AUTHORITY` (`authority_id`),
  CONSTRAINT `FK_ROLEAUTHORITY_REFRENCE_AUTHORITY` FOREIGN KEY (`authority_id`) REFERENCES `app_authority` (`authority_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_ROLEAUTHORITY_REFRENCE_ROLE` FOREIGN KEY (`role_id`) REFERENCES `app_role` (`role_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限表';

-- ----------------------------
-- Records of app_role_authority
-- ----------------------------
INSERT INTO `app_role_authority` VALUES ('1', '6', '1', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('2', '6', '2', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('3', '6', '3', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('4', '6', '4', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('5', '6', '5', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('6', '6', '6', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('7', '6', '7', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('8', '6', '8', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('9', '6', '9', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('10', '6', '10', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('11', '6', '11', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('12', '6', '12', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('13', '6', '13', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('14', '6', '14', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('15', '6', '15', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('16', '6', '16', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('17', '6', '17', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('18', '6', '18', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('19', '6', '19', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('20', '6', '20', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('21', '6', '21', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('22', '6', '22', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('23', '6', '23', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('24', '6', '24', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('25', '6', '25', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('26', '6', '26', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('27', '6', '27', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('28', '6', '28', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('29', '6', '29', '2016-09-23 16:55:59', '1', null, null, 'n', '');
INSERT INTO `app_role_authority` VALUES ('30', '6', '30', '2016-09-23 16:55:59', '1', null, null, 'n', '');

-- ----------------------------
-- Table structure for app_user
-- ----------------------------
DROP TABLE IF EXISTS `app_user`;
CREATE TABLE `app_user` (
  `user_id` varchar(20) NOT NULL  COMMENT '主键',
  `creator_id` varchar(20) NOT NULL COMMENT '创建人id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(10) DEFAULT NULL COMMENT '修改人id',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `work_num` varchar(20) DEFAULT NULL COMMENT '工号',
  `user_name` varchar(30) DEFAULT NULL COMMENT '用户名',
  `psw_md5` varchar(60) DEFAULT NULL COMMENT '用户密码',
  `name` varchar(10) DEFAULT NULL COMMENT '姓名',
  `phone_num` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `department` varchar(400) DEFAULT NULL COMMENT '员工部门',
  `position` varchar(20) DEFAULT NULL COMMENT '岗位',
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  `remark` varchar(20) DEFAULT NULL COMMENT '信息备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of app_user
-- ----------------------------
INSERT INTO `app_user` VALUES ('1', '1', '2016-09-23 17:02:01', null, null, '91952', 'admin', '97ece0fcf2255215495adaa8e1c6891627d69261', '胡兆鹏', '15355008055', 'zphuc@isoftstone.com', 'businessDepartment', 'resourceManager', 'n', null);
INSERT INTO `app_user` VALUES ('2', '1', '2016-09-23 17:07:46', null, null, null, 'test', '7c4a8d09ca3762af61e59520943dc26494f8941b', '测试用户', null, null, null, null, 'n', null);
INSERT INTO `app_user` VALUES ('200', '2', '2016-09-29 20:53:56', 'system', '2016-09-29 20:53:56', null, null, '7c4a8d09ca3762af61e59520943dc26494f8941b', 'lise', '000000', null, '技术部', '技术经理', 'n', null);

-- ----------------------------
-- Table structure for app_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `app_user_authority`;
CREATE TABLE `app_user_authority` (
  `user_authority_id` varchar(20) NOT NULL  COMMENT '主键',
  `user_id` varchar(20) NOT NULL COMMENT '用户id',
  `authority_id` varchar(20) NOT NULL COMMENT '权限名称',
  `creator_id` varchar(20) NOT NULL COMMENT '创建人',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  `remark` varchar(120) DEFAULT NULL COMMENT '页面权限的名称',
  PRIMARY KEY (`user_authority_id`),
  KEY `FK_USERAUTHOIRTY_REFRENCE_USER` (`user_id`),
  KEY `FK_USERAUTHOIRTY_REFRENCE_AUTHORITY` (`authority_id`),
  CONSTRAINT `FK_USERAUTHOIRTY_REFRENCE_AUTHORITY` FOREIGN KEY (`authority_id`) REFERENCES `app_authority` (`authority_id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_USERAUTHOIRTY_REFRENCE_USER` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户特殊权限表';

-- ----------------------------
-- Records of app_user_authority
-- ----------------------------
INSERT INTO `app_user_authority` VALUES ('1', '2', '30', '1', '2016-09-28 14:58:38', null, null, 'n', null);

-- ----------------------------
-- Table structure for app_user_role
-- ----------------------------
DROP TABLE IF EXISTS `app_user_role`;
CREATE TABLE `app_user_role` (
  `app_user_role_id` varchar(20) NOT NULL  COMMENT '主键',
  `user_id` varchar(20) NOT NULL COMMENT '用户id',
  `role_id` varchar(20) NOT NULL COMMENT '角色id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `creator_id` varchar(20) NOT NULL COMMENT '创建人',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `is_deleted` varchar(1) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`app_user_role_id`),
  KEY `FK_USERROLE_REFERENCE_USERID` (`user_id`),
  CONSTRAINT `FK_USERROLE_REFERENCE_USERID` FOREIGN KEY (`user_id`) REFERENCES `app_user` (`user_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of app_user_role
-- ----------------------------
INSERT INTO `app_user_role` VALUES ('1', '1', '6', '2016-09-23 17:12:19', '1', null, null, 'n', null);
INSERT INTO `app_user_role` VALUES ('2', '2', '6', '2016-09-23 17:12:37', '1', null, null, 'n', null);

-- ----------------------------
-- Table structure for busi_line_user
-- ----------------------------
DROP TABLE IF EXISTS `busi_line_user`;
CREATE TABLE `busi_line_user` (
  `busi_line_user_id` varchar(20) NOT NULL  COMMENT '业务线对应的负责人表的id',
  `user_id` varchar(20) NOT NULL COMMENT '改业务线负责人的id',
  `dictionary_id` varchar(20) NOT NULL COMMENT '业务线id',
  `creator_id` varchar(20) NOT NULL COMMENT '创建人id',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `modifier` varchar(20) DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  PRIMARY KEY (`busi_line_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of busi_line_user
-- ----------------------------

-- ----------------------------
-- Table structure for change_log
-- ----------------------------
DROP TABLE IF EXISTS `change_log`;
CREATE TABLE `change_log` (
  `change_log_id` varchar(20) NOT NULL  COMMENT '主键',
  `gmt_create` datetime NOT NULL COMMENT '@desc 创建时间',
  `creator_id` varchar(20) NOT NULL COMMENT '@desc 创建人',
  `modifier` varchar(20) DEFAULT NULL COMMENT '@desc 修改者',
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '@desc 修改时间',
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '@desc   是否删除',
  `ori_value` varchar(1024) DEFAULT NULL COMMENT '@desc   原值',
  `new_value` varchar(1024) DEFAULT NULL COMMENT '@desc   新值',
  `entity_id` varchar(20) DEFAULT NULL COMMENT '@desc   实体id',
  `entity_name` varchar(80) DEFAULT NULL COMMENT '@desc   实体名',
  `entity_field` varchar(40) DEFAULT NULL COMMENT '@desc   实体中被改动的字段',
  `remark` varchar(10) DEFAULT NULL COMMENT '备注信息：新增，修改，删除',
  PRIMARY KEY (`change_log_id`),
  KEY `idx_entity_id` (`entity_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='变更日志记录';

-- ----------------------------
-- Records of change_log
-- ----------------------------
INSERT INTO `change_log` VALUES ('68', '2016-09-29 20:53:55', '1', 'system', '2016-09-29 20:53:56', 'n', '100', '200', '100', 'com.issali.model.AppUser', 'appUserId', '修改');
INSERT INTO `change_log` VALUES ('69', '2016-09-29 20:53:55', '1', 'system', '2016-09-29 20:53:56', 'n', '张三', 'lise', '100', 'com.issali.model.AppUser', 'name', '修改');
INSERT INTO `change_log` VALUES ('70', '2016-09-29 20:53:55', '1', 'system', '2016-09-29 20:53:56', 'n', '12345698700', '000000', '100', 'com.issali.model.AppUser', 'phoneNum', '修改');
INSERT INTO `change_log` VALUES ('71', '2016-09-29 20:53:55', '1', 'system', '2016-09-29 20:53:56', 'n', '技术经理333', '技术经理', '100', 'com.issali.model.AppUser', 'position', '修改');
INSERT INTO `change_log` VALUES ('72', '2016-09-29 21:07:44', '1', 'system', '2016-09-29 21:07:46', 'n', 'null', '200', null, 'com.issali.model.AppUser', 'appUserId', '增加');
INSERT INTO `change_log` VALUES ('73', '2016-09-29 21:07:46', '1', 'system', '2016-09-29 21:07:49', 'n', '张三', 'lise', null, 'com.issali.model.AppUser', 'name', '增加');
INSERT INTO `change_log` VALUES ('74', '2016-09-29 21:07:48', '1', 'system', '2016-09-29 21:07:49', 'n', '12345698700', '000000', null, 'com.issali.model.AppUser', 'phoneNum', '增加');
INSERT INTO `change_log` VALUES ('75', '2016-09-29 21:07:48', '1', 'system', '2016-09-29 21:07:49', 'n', '技术经理333', '技术经理', null, 'com.issali.model.AppUser', 'position', '增加');
INSERT INTO `change_log` VALUES ('76', '2016-09-30 11:36:50', '1', 'system', '2016-09-30 11:36:51', 'n', 'null', '200', null, 'com.issali.model.AppUser', 'appUserId', '增加');
INSERT INTO `change_log` VALUES ('77', '2016-09-30 11:36:50', '1', 'system', '2016-09-30 11:36:51', 'n', '张三', 'lise', null, 'com.issali.model.AppUser', 'name', '增加');
INSERT INTO `change_log` VALUES ('78', '2016-09-30 11:36:50', '1', 'system', '2016-09-30 11:36:51', 'n', '12345698700', '000000', null, 'com.issali.model.AppUser', 'phoneNum', '增加');
INSERT INTO `change_log` VALUES ('79', '2016-09-30 11:36:50', '1', 'system', '2016-09-30 11:36:51', 'n', '技术经理333', '技术经理', null, 'com.issali.model.AppUser', 'position', '增加');
INSERT INTO `change_log` VALUES ('80', '2016-09-30 11:43:55', '1', 'system', '2016-09-30 11:43:55', 'n', 'null', '200', null, 'com.issali.model.AppUser', 'appUserId', '增加');
INSERT INTO `change_log` VALUES ('81', '2016-09-30 11:43:55', '1', 'system', '2016-09-30 11:43:55', 'n', '张三', 'lise', null, 'com.issali.model.AppUser', 'name', '增加');
INSERT INTO `change_log` VALUES ('82', '2016-09-30 11:43:55', '1', 'system', '2016-09-30 11:43:55', 'n', '12345698700', '000000', null, 'com.issali.model.AppUser', 'phoneNum', '增加');
INSERT INTO `change_log` VALUES ('83', '2016-09-30 11:43:55', '1', 'system', '2016-09-30 11:43:55', 'n', '技术经理333', '技术经理', null, 'com.issali.model.AppUser', 'position', '增加');
INSERT INTO `change_log` VALUES ('84', '2016-09-30 11:44:46', '1', 'system', '2016-09-30 11:44:47', 'n', 'null', '200', null, 'com.issali.model.AppUser', 'appUserId', '增加');
INSERT INTO `change_log` VALUES ('85', '2016-09-30 11:44:46', '1', 'system', '2016-09-30 11:44:47', 'n', '张三', 'lise', null, 'com.issali.model.AppUser', 'name', '增加');
INSERT INTO `change_log` VALUES ('86', '2016-09-30 11:44:46', '1', 'system', '2016-09-30 11:44:47', 'n', '12345698700', '000000', null, 'com.issali.model.AppUser', 'phoneNum', '增加');
INSERT INTO `change_log` VALUES ('87', '2016-09-30 11:44:46', '1', 'system', '2016-09-30 11:44:47', 'n', '技术经理333', '技术经理', null, 'com.issali.model.AppUser', 'position', '增加');
INSERT INTO `change_log` VALUES ('88', '2016-09-30 11:46:40', '1', 'system', '2016-09-30 11:46:41', 'n', 'null', '200', null, 'com.issali.model.AppUser', 'appUserId', '增加');
INSERT INTO `change_log` VALUES ('89', '2016-09-30 11:46:40', '1', 'system', '2016-09-30 11:46:41', 'n', '张三', 'lise', null, 'com.issali.model.AppUser', 'name', '增加');
INSERT INTO `change_log` VALUES ('90', '2016-09-30 11:46:40', '1', 'system', '2016-09-30 11:46:41', 'n', '12345698700', '000000', null, 'com.issali.model.AppUser', 'phoneNum', '增加');
INSERT INTO `change_log` VALUES ('91', '2016-09-30 11:46:40', '1', 'system', '2016-09-30 11:46:41', 'n', '技术经理333', '技术经理', null, 'com.issali.model.AppUser', 'position', '增加');
INSERT INTO `change_log` VALUES ('92', '2016-09-30 11:47:52', '1', 'system', '2016-09-30 11:47:53', 'n', 'null', '200', null, 'com.issali.model.AppUser', 'appUserId', '增加');
INSERT INTO `change_log` VALUES ('93', '2016-09-30 11:47:52', '1', 'system', '2016-09-30 11:47:53', 'n', '张三', 'lise', null, 'com.issali.model.AppUser', 'name', '增加');
INSERT INTO `change_log` VALUES ('94', '2016-09-30 11:47:52', '1', 'system', '2016-09-30 11:47:53', 'n', '12345698700', '000000', null, 'com.issali.model.AppUser', 'phoneNum', '增加');
INSERT INTO `change_log` VALUES ('95', '2016-09-30 11:47:52', '1', 'system', '2016-09-30 11:47:53', 'n', '技术经理333', '技术经理', null, 'com.issali.model.AppUser', 'position', '增加');
INSERT INTO `change_log` VALUES ('96', '2016-09-30 14:44:05', '1', 'system', '2016-09-30 14:44:06', 'n', 'null', '200', null, 'com.issali.model.AppUser', 'appUserId', '增加');
INSERT INTO `change_log` VALUES ('97', '2016-09-30 14:44:05', '1', 'system', '2016-09-30 14:44:06', 'n', '张三', 'lise', null, 'com.issali.model.AppUser', 'name', '增加');
INSERT INTO `change_log` VALUES ('98', '2016-09-30 14:44:05', '1', 'system', '2016-09-30 14:44:06', 'n', '12345698700', '000000', null, 'com.issali.model.AppUser', 'phoneNum', '增加');
INSERT INTO `change_log` VALUES ('99', '2016-09-30 14:44:05', '1', 'system', '2016-09-30 14:44:06', 'n', '技术经理333', '技术经理', null, 'com.issali.model.AppUser', 'position', '增加');
INSERT INTO `change_log` VALUES ('100', '2016-09-30 14:49:35', '1', 'system', '2016-09-30 14:49:36', 'n', 'null', '200', null, 'com.issali.model.AppUser', 'appUserId', '增加');
INSERT INTO `change_log` VALUES ('101', '2016-09-30 14:49:35', '1', 'system', '2016-09-30 14:49:36', 'n', '张三', 'lise', null, 'com.issali.model.AppUser', 'name', '增加');
INSERT INTO `change_log` VALUES ('102', '2016-09-30 14:49:35', '1', 'system', '2016-09-30 14:49:36', 'n', '12345698700', '000000', null, 'com.issali.model.AppUser', 'phoneNum', '增加');
INSERT INTO `change_log` VALUES ('103', '2016-09-30 14:49:35', '1', 'system', '2016-09-30 14:49:36', 'n', '技术经理333', '技术经理', null, 'com.issali.model.AppUser', 'position', '增加');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` varchar(20) NOT NULL  COMMENT '主键',
  `creator_id` varchar(20) NOT NULL COMMENT '创建人',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `instance_id` varchar(20) DEFAULT NULL COMMENT '评论对象的id,例如：评论应聘人员，那就是resume_id',
  `instance_type` varchar(20) DEFAULT NULL COMMENT '评论事项的类型：demand，是需求；resume，是简历',
  `comment_type` varchar(20) DEFAULT NULL COMMENT '评论类型：ordinary，普通评论；thumb_up,点赞',
  `context` varchar(500) DEFAULT NULL COMMENT '评论的内容',
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for demand_detail
-- ----------------------------
DROP TABLE IF EXISTS `demand_detail`;
CREATE TABLE `demand_detail` (
  `demand_detail_id` varchar(20) NOT NULL  COMMENT '主键',
  `recruitment_consultant_id` varchar(20) DEFAULT NULL COMMENT '招聘顾问的id,存储的是user_id',
  `demand_id` varchar(20) NOT NULL COMMENT '关联的需求id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `station` varchar(20) DEFAULT NULL COMMENT '需求岗位',
  `need_count` varchar(20) DEFAULT NULL COMMENT '需求人数',
  `arrival_time` datetime DEFAULT NULL COMMENT '到岗时间',
  `tech_level` varchar(20) DEFAULT NULL COMMENT '技术水平',
  `demand_detail_state` varchar(20) DEFAULT NULL COMMENT '该需求详情的状态：0.不通过，1.已保存，2.已提交，3.审核通过，4.关闭',
  `station_require` varchar(1000) DEFAULT NULL COMMENT '岗位要求',
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '是否删除:n未删除,y已删除',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`demand_detail_id`),
  KEY `FK_DEMANDDETAIL_REFRENCE_DEMAND` (`demand_id`),
  CONSTRAINT `FK_DEMANDDETAIL_REFRENCE_DEMAND` FOREIGN KEY (`demand_id`) REFERENCES `job_demand` (`job_demand_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='需求详情表';

-- ----------------------------
-- Records of demand_detail
-- ----------------------------

-- ----------------------------
-- Table structure for job_demand
-- ----------------------------
DROP TABLE IF EXISTS `job_demand`;
CREATE TABLE `job_demand` (
  `job_demand_id` varchar(20) NOT NULL  COMMENT '主键',
  `demand_num` varchar(30) NOT NULL COMMENT '需求编号，格式：XQ2xxxxxxxxxxx',
  `creator_id` varchar(20) NOT NULL COMMENT '@desc 创建人id',
  `gmt_create` datetime NOT NULL COMMENT '@desc 创建时间',
  `modifier` varchar(20) DEFAULT NULL COMMENT '@desc 修改人',
  `gmt_modified` datetime DEFAULT NULL COMMENT '@desc 修改时间',
  `department` varchar(20) DEFAULT NULL COMMENT '需求发布人的部门',
  `project_name` varchar(40) DEFAULT NULL COMMENT '项目名称',
  `project_num` varchar(20) DEFAULT NULL COMMENT '项目编号',
  `busi_line` varchar(20) DEFAULT NULL COMMENT '业务线',
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  `remark` varchar(1000) DEFAULT NULL COMMENT '需求备注',
  PRIMARY KEY (`job_demand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='招聘需求表';

-- ----------------------------
-- Records of job_demand
-- ----------------------------

-- ----------------------------
-- Table structure for resume
-- ----------------------------
DROP TABLE IF EXISTS `resume`;
CREATE TABLE `resume` (
  `resume_id` varchar(20) NOT NULL  COMMENT '主键',
  `resume_num` varchar(30) NOT NULL COMMENT '简历编号，格式：JL2xxxxxxxxxxx',
  `creator_id` varchar(20) NOT NULL COMMENT '创建人id',
  `gmt_create` datetime DEFAULT NULL COMMENT '创建时间',
  `demand_id` varchar(20) DEFAULT NULL COMMENT '关联需求的id',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `name` varchar(20) NOT NULL COMMENT '简历人姓名',
  `id_card` varchar(20) DEFAULT NULL COMMENT '简历人的身份证号码',
  `gender` varchar(10) DEFAULT NULL COMMENT '性别：男，女，其他',
  `birthday` varchar(20) DEFAULT NULL COMMENT '出生日期',
  `origin_place` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `phone_num` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `work_year` float DEFAULT NULL COMMENT '工作年限',
  `station` varchar(50) DEFAULT NULL COMMENT '应聘岗位',
  `self_eval` varchar(400) DEFAULT NULL COMMENT '自我评价',
  `res_state` int(11) NOT NULL DEFAULT '0' COMMENT '简历状态：0.未关联的自由状态，1.关联状态，2.待面试状态,。。。',
  `residence` varchar(20) DEFAULT NULL COMMENT '居住地',
  `exp_place` varchar(20) DEFAULT NULL COMMENT '期望工作地',
  `resume_type` int(11) NOT NULL DEFAULT '0' COMMENT '简历类型：0普通类型，1众推类型',
  `is_deleted` char(20) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  `storage_path` varchar(400) DEFAULT NULL COMMENT '简历附件的存放路径',
  `info_remark` varchar(400) DEFAULT NULL COMMENT '简历基本信息备注',
  `state_remark` varchar(400) DEFAULT NULL COMMENT '简历状态备注',
  PRIMARY KEY (`resume_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简历信息表';

-- ----------------------------
-- Records of resume
-- ----------------------------

-- ----------------------------
-- Table structure for resume_detail
-- ----------------------------
DROP TABLE IF EXISTS `resume_detail`;
CREATE TABLE `resume_detail` (
  `resume_detail_id` varchar(20) NOT NULL  COMMENT '主键',
  `resume_id` varchar(20) NOT NULL COMMENT '简历id',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `det_type` varchar(50) DEFAULT NULL COMMENT '详情类型：如，工作经历，教育经历，培训经历',
  `start_time` datetime DEFAULT NULL COMMENT '详情类型的起始时间',
  `end_time` datetime DEFAULT NULL COMMENT '详情类型的起始时间',
  `det_context` varchar(50) DEFAULT NULL COMMENT '详情类型的内容',
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '详情类型是否删除',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`resume_detail_id`),
  KEY `FK_RESUMEDETAIL_REFRENCE_RESUME` (`resume_id`),
  CONSTRAINT `FK_RESUMEDETAIL_REFRENCE_RESUME` FOREIGN KEY (`resume_id`) REFERENCES `resume` (`resume_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简历详情表';

-- ----------------------------
-- Records of resume_detail
-- ----------------------------

-- ----------------------------
-- Table structure for resume_docking
-- ----------------------------
DROP TABLE IF EXISTS `resume_docking`;
CREATE TABLE `resume_docking` (
  `resume_docking_id` varchar(20) NOT NULL  COMMENT '主键',
  `creator_id` varchar(20) NOT NULL COMMENT '创建人',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `resume_id` varchar(20) DEFAULT NULL COMMENT '简历id',
  `demand_detail_id` varchar(20) DEFAULT NULL COMMENT '需求详情编号',
  `demand_id` varchar(20) DEFAULT NULL COMMENT '需求编号',
  `resume_state` int(11) DEFAULT NULL COMMENT '简历状态',
  `is_pass` varchar(10) DEFAULT NULL COMMENT '面试是否通过',
  `information` varchar(500) DEFAULT NULL COMMENT '面试备注信息',
  `expectation_salary` varchar(10) DEFAULT NULL COMMENT '期望薪资',
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`resume_docking_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='简历操作表';

-- ----------------------------
-- Records of resume_docking
-- ----------------------------

-- ----------------------------
-- Table structure for to_do_list
-- ----------------------------
DROP TABLE IF EXISTS `to_do_list`;
CREATE TABLE `to_do_list` (
  `to_do_lsit_id` varchar(20) NOT NULL  COMMENT '主键',
  `creator_id` varchar(20) NOT NULL COMMENT '创建人',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `handler_id` varchar(20) NOT NULL COMMENT '待处理事项处理人的id',
  `assigne_type` varchar(20) DEFAULT NULL COMMENT '待办事项人的参与类型：participator，指定处理的人；candidate，可以对该事项处理（候选人）',
  `instance_type` varchar(20) DEFAULT NULL COMMENT '待处理事项的类型：demand，是需求；resume，是简历',
  `instance_id` varchar(20) DEFAULT NULL COMMENT '待处理事项的id：如果是demand类型的，就是demand_id；如果是resume类型，是resume_id',
  `version` int(11) DEFAULT NULL COMMENT '待处理事项的版本号，用来区分同一个需求或者简历多次成为代办事项',
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`to_do_lsit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='待处理事项表';

-- ----------------------------
-- Records of to_do_list
-- ----------------------------

-- ----------------------------
-- Table structure for to_do_list_history
-- ----------------------------
DROP TABLE IF EXISTS `to_do_list_history`;
CREATE TABLE `to_do_list_history` (
  `to_do_list_history_id` varchar(20) NOT NULL  COMMENT '主键',
  `creator_id` varchar(20) NOT NULL COMMENT '创建人',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `handler_id` varchar(20) NOT NULL COMMENT '待处理事项处理人的id',
  `end_time` datetime DEFAULT NULL COMMENT '待处理事项处理时间',
  `assigne_type` varchar(20) DEFAULT NULL COMMENT '待办事项人的参与类型：participator，指定处理的人；candidate，可以对该事项处理（候选人）',
  `instance_type` varchar(20) DEFAULT NULL COMMENT '待处理事项的类型：demand，是需求；resume，是简历',
  `instance_id` varchar(20) DEFAULT NULL COMMENT '待处理事项的id：如果是demand类型的，就是demand_id；如果是resume类型，是resume_id',
  `version` int(11) DEFAULT NULL COMMENT '待处理事项的版本号，用来区分同一个需求或者简历多次成为代办事项',
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`to_do_list_history_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='待处理事项历史表';

-- ----------------------------
-- Records of to_do_list_history
-- ----------------------------

-- ----------------------------
-- Table structure for user_login_record
-- ----------------------------
DROP TABLE IF EXISTS `user_login_record`;
CREATE TABLE `user_login_record` (
  `user_login_record_id` varchar(20) NOT NULL  COMMENT '主键',
  `user_id` varchar(20) DEFAULT NULL COMMENT '用户id',
  `creator_id` varchar(20) NOT NULL COMMENT '创建人',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  `modifier` varchar(20) DEFAULT NULL COMMENT '修改人',
  `fail_type` int(11) DEFAULT NULL COMMENT '失败类型：0.psw_erro',
  `fail_information` varchar(50) DEFAULT NULL COMMENT '失败信息',
  `is_deleted` char(1) NOT NULL DEFAULT 'n' COMMENT '是否删除',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_login_record_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户登录记录表';

-- ----------------------------
-- Records of user_login_record
-- ----------------------------
