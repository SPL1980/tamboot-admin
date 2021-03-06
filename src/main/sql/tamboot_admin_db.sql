/*
Navicat MySQL Data Transfer

Source Server         : local-db
Source Server Version : 50719
Source Host           : 127.0.0.1:3306
Source Database       : tamboot_admin_db

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-06-19 02:32:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for system_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_menu`;
CREATE TABLE `system_menu` (
  `id` bigint(20) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `path` varchar(64) DEFAULT NULL,
  `locale` varchar(128) DEFAULT NULL,
  `name` varchar(64) DEFAULT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `parent` bigint(20) DEFAULT NULL,
  `order_index` int(5) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_menu
-- ----------------------------
INSERT INTO `system_menu` VALUES ('6533916193823133696', '7', '2019-05-14 12:10:14', '1', '2019-05-16 11:23:41', '1', '/system', null, '系统配置', 'setting', null, '0');
INSERT INTO `system_menu` VALUES ('6533916677858398211', '19', '2019-05-14 12:12:10', '1', '2019-06-02 01:04:51', '1', '/system/menu', null, '菜单管理', null, '6533916193823133696', '2');
INSERT INTO `system_menu` VALUES ('6533916797031157764', '8', '2019-05-14 12:12:38', '1', '2019-06-02 01:04:56', '1', '/system/role', null, '角色管理', null, '6533916193823133696', '3');
INSERT INTO `system_menu` VALUES ('6536608913624666112', '2', '2019-05-21 22:30:09', '1', '2019-06-02 01:04:59', '1', '/system/permission', null, '访问权限', null, '6533916193823133696', '4');
INSERT INTO `system_menu` VALUES ('6536612123282247681', '1', '2019-05-21 22:42:54', '1', '2019-06-02 01:04:39', '1', '/system/user', null, '用户管理', null, '6533916193823133696', '1');
INSERT INTO `system_menu` VALUES ('6533917218659373061', '10', '2019-05-14 12:14:19', '1', '2019-06-02 22:18:26', '1', '/user', null, '用户中心', 'user', null, '2');
INSERT INTO `system_menu` VALUES ('6533917345537069062', '3', '2019-05-14 12:14:49', '1', '2019-06-02 22:39:47', '1', '/user/password', null, '修改密码', null, '6533917218659373061', '0');

-- ----------------------------
-- Table structure for system_permission
-- ----------------------------
DROP TABLE IF EXISTS `system_permission`;
CREATE TABLE `system_permission` (
  `id` bigint(20) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `url` varchar(64) DEFAULT NULL,
  `roles` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_permission
-- ----------------------------
INSERT INTO `system_permission` VALUES ('1', '3', null, null, '2019-06-09 19:29:32', '1', '/user/**', 'MANAGER,USER');
INSERT INTO `system_permission` VALUES ('2', '0', null, null, null, null, '/system/**', 'MANAGER');
INSERT INTO `system_permission` VALUES ('3', '0', null, null, null, null, '/**', 'MANAGER');

-- ----------------------------
-- Table structure for system_role
-- ----------------------------
DROP TABLE IF EXISTS `system_role`;
CREATE TABLE `system_role` (
  `id` bigint(20) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `role_code` varchar(16) DEFAULT NULL,
  `role_name` varchar(32) DEFAULT NULL,
  `role_desc` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_role_code` (`role_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_role
-- ----------------------------
INSERT INTO `system_role` VALUES ('1', '0', null, null, '2019-06-02 17:03:25', '1', 'MANAGER', '管理员', '进行系统的日常运维');
INSERT INTO `system_role` VALUES ('2', '0', '2019-05-13 17:37:13', '1', null, null, 'USER', '用户', '普通用户');

-- ----------------------------
-- Table structure for system_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `system_role_menu`;
CREATE TABLE `system_role_menu` (
  `id` bigint(20) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `role_code` varchar(16) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_role_menu
-- ----------------------------
INSERT INTO `system_role_menu` VALUES ('6533981267954765825', '0', '2019-05-14 16:28:49', '1', null, null, 'MANAGER', '6533916193823133696');
INSERT INTO `system_role_menu` VALUES ('6533981267984125954', '0', '2019-05-14 16:28:49', '1', null, null, 'MANAGER', '6533916677858398211');
INSERT INTO `system_role_menu` VALUES ('6533981268063817732', '0', '2019-05-14 16:28:49', '1', null, null, 'MANAGER', '6533916797031157764');
INSERT INTO `system_role_menu` VALUES ('6533981268088983557', '0', '2019-05-14 16:28:49', '1', null, null, 'MANAGER', '6533917345537069062');
INSERT INTO `system_role_menu` VALUES ('6533981268114149382', '0', '2019-05-14 16:28:49', '1', null, null, 'MANAGER', '6533917218659373061');
INSERT INTO `system_role_menu` VALUES ('6536609193594458112', '0', '2019-05-21 22:31:16', '1', null, null, 'MANAGER', '6536608913624666112');
INSERT INTO `system_role_menu` VALUES ('6540485233114877952', '0', '2019-06-01 15:13:15', '1', null, null, 'MANAGER', '6536612123282247681');

-- ----------------------------
-- Table structure for system_user
-- ----------------------------
DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `id` bigint(20) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_user
-- ----------------------------
INSERT INTO `system_user` VALUES ('1', '0', null, null, '2019-06-02 22:43:43', '1', 'admin', '{bcrypt}$2a$10$wJ78miQmI0k7PL70bUkjIOqmvKm1tkEsnN2JWP6bjB.wNl6Hm61iq', '1');
INSERT INTO `system_user` VALUES ('2', '0', null, null, '2019-06-02 12:56:17', '1', 'user', '{bcrypt}$2a$10$3lRGVEr06pErbsUxDqh1JeNocMA.pn/9SrRbS4WfyrZgXqRC87tyO', '0');

-- ----------------------------
-- Table structure for system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `system_user_role`;
CREATE TABLE `system_user_role` (
  `id` bigint(20) NOT NULL,
  `version` bigint(20) DEFAULT '0',
  `create_time` datetime DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `modifier` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `role_code` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of system_user_role
-- ----------------------------
INSERT INTO `system_user_role` VALUES ('6540626859242033153', '0', '2019-06-02 00:36:02', '1', null, null, '2', 'USER');
INSERT INTO `system_user_role` VALUES ('6540633650185113600', '0', '2019-06-02 01:03:01', '1', null, null, '1', 'MANAGER');
