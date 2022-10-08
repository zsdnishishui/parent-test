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

 Date: 08/10/2022 20:43:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_request_path_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_request_path_permission_relation`;
CREATE TABLE `sys_request_path_permission_relation`  (
  `id` int(0) NULL DEFAULT NULL COMMENT '主键id',
  `url_id` int(0) NULL DEFAULT NULL COMMENT '请求路径id',
  `permission_id` int(0) NULL DEFAULT NULL COMMENT '权限id'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '路径权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_request_path_permission_relation
-- ----------------------------
INSERT INTO `sys_request_path_permission_relation` VALUES (1, 1, 2);

SET FOREIGN_KEY_CHECKS = 1;
