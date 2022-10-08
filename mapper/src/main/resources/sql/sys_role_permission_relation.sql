/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.11
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 192.168.1.11:3306
 Source Schema         : sso

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 08/10/2022 20:44:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission_relation`;
CREATE TABLE `sys_role_permission_relation`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `role_id` int(0) NULL DEFAULT NULL COMMENT '角色id',
  `permission_id` int(0) NULL DEFAULT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色-权限关联关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_permission_relation
-- ----------------------------
INSERT INTO `sys_role_permission_relation` VALUES (1, 1, 1);
INSERT INTO `sys_role_permission_relation` VALUES (2, 1, 2);
INSERT INTO `sys_role_permission_relation` VALUES (3, 1, 3);
INSERT INTO `sys_role_permission_relation` VALUES (4, 1, 4);
INSERT INTO `sys_role_permission_relation` VALUES (5, 2, 1);
INSERT INTO `sys_role_permission_relation` VALUES (6, 2, 2);

SET FOREIGN_KEY_CHECKS = 1;
