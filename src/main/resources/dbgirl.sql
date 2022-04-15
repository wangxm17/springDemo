/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : 127.0.0.1:3306
 Source Schema         : dbgirl

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 15/04/2022 15:33:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `iconCls` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `path` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '浏览器地址后缀',
  `url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件路径',
  `fatherId` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级菜单id',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `creater` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `updater` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '一级无子菜单', 'el-icon-location', 'One', '@/components/Layouts', '0', '2021-10-29 17:13:40', '2021-10-29 17:13:40', '1', '1');
INSERT INTO `permission` VALUES ('2', '首页', 'el-icon-s-home', 'shouye', '@/views/shouye/index', '1', '2021-10-29 17:13:40', '2021-11-11 14:04:26', '1', '1');
INSERT INTO `permission` VALUES ('3', '系统管理', 'el-icon-s-tools', 'index', '@/components/Layouts', '0', '2021-10-29 17:13:40', '2021-11-11 07:35:00', '1', '1');
INSERT INTO `permission` VALUES ('4', 'HelloWorld', 'el-icon-phone', 'home', '@/components/HelloWorld', '3', '2021-10-29 17:13:40', '2021-11-11 14:03:37', '1', '1');
INSERT INTO `permission` VALUES ('5', '用户管理', 'el-icon-user-solid', 'user', '@/views/User/userTable', '3', '2021-10-29 17:13:40', '2021-11-19 05:37:37', '1', '1');
INSERT INTO `permission` VALUES ('6', '角色管理', 'el-icon-s-fold', 'role', '@/views/Role/roleTable', '3', '2021-10-29 17:13:40', '2021-11-19 05:37:47', '1', '1');
INSERT INTO `permission` VALUES ('69176a8d-28fd-4227-ac2c-c4ea9890e447', 'HelloWorldOne', 'el-icon-folder-checked', 'homeOne', '@/components/HelloWorldOne', '3', '2021-12-09 05:42:16', '2021-12-09 05:43:13', NULL, NULL);
INSERT INTO `permission` VALUES ('7', '菜单管理', 'el-icon-tickets', 'menu', '@/views/Menu/menuTable', '3', '2021-11-11 09:58:39', '2021-11-19 05:37:55', '1', '1');
INSERT INTO `permission` VALUES ('8', '地图', 'el-icon-thumb', 'map', '@/views/map/map', '3', '2021-11-11 16:25:20', '2021-11-11 14:03:19', '1', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `describtion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '普通用户', '这是普通用户', '2021-07-08 07:59:05', '2021-11-11 07:52:25');
INSERT INTO `role` VALUES ('227e6710-1666-4c90-9303-e5a0a0c7548e', '超级管理员', '超级管理员', '2021-11-10 08:00:32', NULL);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色ID',
  `pid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜单ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('56d21116-6554-4797-ab3c-e7f25ee4b1e3', '227e6710-1666-4c90-9303-e5a0a0c7548e', '1');
INSERT INTO `role_permission` VALUES ('75bbd338-901e-48b7-bdae-8f1dd143b00c', '227e6710-1666-4c90-9303-e5a0a0c7548e', '5');
INSERT INTO `role_permission` VALUES ('7bde600c-487e-4b27-8029-f455a26b8844', '1', '1');
INSERT INTO `role_permission` VALUES ('7c4c1f49-f648-458e-b1c7-b9cebc4b5d2f', '1', '5');
INSERT INTO `role_permission` VALUES ('808867bc-6213-4813-be76-e11875af301b', '1', '4');
INSERT INTO `role_permission` VALUES ('9ab788a6-1b46-4749-afb5-1e3b4656479d', '227e6710-1666-4c90-9303-e5a0a0c7548e', '7');
INSERT INTO `role_permission` VALUES ('acf4dccf-b054-4dac-9a31-1f530868f93e', '227e6710-1666-4c90-9303-e5a0a0c7548e', '6');
INSERT INTO `role_permission` VALUES ('d3e7eab7-a38f-4554-8432-d2aa47110779', '227e6710-1666-4c90-9303-e5a0a0c7548e', '8');
INSERT INTO `role_permission` VALUES ('d4849a26-b609-47fd-8990-bf5f81160e8d', '227e6710-1666-4c90-9303-e5a0a0c7548e', '4');
INSERT INTO `role_permission` VALUES ('dae76a2c-4527-4534-ae33-a283d9875721', '227e6710-1666-4c90-9303-e5a0a0c7548e', '2');
INSERT INTO `role_permission` VALUES ('e81cefde-5d78-4c40-80c0-adaa48bdae98', '227e6710-1666-4c90-9303-e5a0a0c7548e', '3');
INSERT INTO `role_permission` VALUES ('fa17870f-4916-46b9-b981-c5bf80156b8a', '1', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `status` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '状态',
  `head_image` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zhangsan', '1', '2021-08-03 17:10:50', '2021-11-10 09:15:08', NULL, NULL);
INSERT INTO `user` VALUES ('2', '6364', '6433', '2021-08-02 05:58:56', '2021-11-10 08:22:33', NULL, NULL);
INSERT INTO `user` VALUES ('3', 'admin', 'admin', '2021-08-02 06:44:08', NULL, NULL, NULL);
INSERT INTO `user` VALUES ('4', '32', '3213', '2021-10-29 01:45:39', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `uid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '用户id',
  `rid` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('2', '2', '1');
INSERT INTO `user_role` VALUES ('3', '3', '1');
INSERT INTO `user_role` VALUES ('4', '4', '1');
INSERT INTO `user_role` VALUES ('55fff5b2-7389-462b-9db4-6e643e4cc2fd', '1', '227e6710-1666-4c90-9303-e5a0a0c7548e');
INSERT INTO `user_role` VALUES ('62a60335-0ed9-49df-bc50-b6daaeb6c5f1', '1', '1');

SET FOREIGN_KEY_CHECKS = 1;
