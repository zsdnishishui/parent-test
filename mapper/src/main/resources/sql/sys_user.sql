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

 Date: 08/10/2022 20:44:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账号',
  `user_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '上一次登录时间',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '账号是否可用。默认为1（可用）',
  `not_expired` tinyint(1) NULL DEFAULT 1 COMMENT '是否过期。默认为1（没有过期）',
  `account_non_locked` tinyint(1) NULL DEFAULT 1 COMMENT '账号是否锁定。默认为1（没有锁定）',
  `credentials_non_expired` tinyint(1) NULL DEFAULT 1 COMMENT '证书（密码）是否过期。默认为1（没有过期）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `create_user` int(0) NULL DEFAULT NULL COMMENT '创建人',
  `update_user` int(0) NULL DEFAULT NULL COMMENT '修改人',
  `account_non_expired` tinyint(1) NULL DEFAULT NULL COMMENT '账号是否过期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'user1', '用户1', '$2a$10$47lsFAUlWixWG17Ca3M/r.EPJVIb7Tv26ZaxhzqN65nXVcAhHQM4i', '2019-09-04 20:25:36', 1, 1, 1, 1, '2019-09-04 20:25:36', '2019-09-04 20:25:36', 1, 1, 1);
INSERT INTO `sys_user` VALUES (2, 'user2', '用户2', '$2a$10$uSLAeON6HWrPbPCtyqPRj.hvZfeM.tiVDZm24/gRqm4opVze1cVvC', '2022-10-08 19:58:38', 1, 1, 1, 1, '2019-09-04 20:25:36', '2022-10-08 19:58:38', 1, 2, 1);

SET FOREIGN_KEY_CHECKS = 1;
