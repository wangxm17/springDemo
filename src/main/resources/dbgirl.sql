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

 Date: 12/05/2022 08:53:52
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
INSERT INTO `permission` VALUES ('368a69d8-81cd-4326-aec3-a305b7ae1594', '文件导出', 'el-icon-s-order', 'fileChoose', '@/views/fileExport/fileChoose', '3', '2022-05-06 07:54:42', '2022-05-06 09:20:04', NULL, NULL);
INSERT INTO `permission` VALUES ('4', '网页模板', 'el-icon-document-copy', 'home', '@/components/HelloWorld', '3', '2021-10-29 17:13:40', '2022-05-10 07:00:27', '1', '1');
INSERT INTO `permission` VALUES ('5', '用户管理', 'el-icon-user-solid', 'user', '@/views/User/userTable', '3', '2021-10-29 17:13:40', '2021-11-19 05:37:37', '1', '1');
INSERT INTO `permission` VALUES ('6', '角色管理', 'el-icon-s-fold', 'role', '@/views/Role/roleTable', '3', '2021-10-29 17:13:40', '2021-11-19 05:37:47', '1', '1');
INSERT INTO `permission` VALUES ('69176a8d-28fd-4227-ac2c-c4ea9890e447', '我的文件', 'el-icon-s-cooperation', 'fileMsg', '@/views/FileMsg/fileMsg', '3', '2021-12-09 05:42:16', '2022-04-21 01:04:17', NULL, NULL);
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
INSERT INTO `role_permission` VALUES ('0de5f5c7-e9e0-4cbe-9759-55aef86a3af4', '227e6710-1666-4c90-9303-e5a0a0c7548e', '4');
INSERT INTO `role_permission` VALUES ('1d746c06-68f6-457f-a9bf-61bc74859fa7', '227e6710-1666-4c90-9303-e5a0a0c7548e', '7');
INSERT INTO `role_permission` VALUES ('33681954-224e-4247-af47-b68bf0935754', '1', '8');
INSERT INTO `role_permission` VALUES ('4e4c6166-4374-4341-822d-c7ef4f6105fe', '227e6710-1666-4c90-9303-e5a0a0c7548e', '5');
INSERT INTO `role_permission` VALUES ('5816ffd3-4412-4d61-be03-93aa8d62bb23', '1', '368a69d8-81cd-4326-aec3-a305b7ae1594');
INSERT INTO `role_permission` VALUES ('5da74092-7746-43d2-b58b-987888422126', '1', '2');
INSERT INTO `role_permission` VALUES ('655778d7-baab-48c6-bf11-34b65b136e7e', '227e6710-1666-4c90-9303-e5a0a0c7548e', '6');
INSERT INTO `role_permission` VALUES ('6c3c2357-28d8-4cf7-a811-59ae9b1e820b', '1', '3');
INSERT INTO `role_permission` VALUES ('8ef002d4-a2f4-4528-95df-9158d5e8c178', '227e6710-1666-4c90-9303-e5a0a0c7548e', '8');
INSERT INTO `role_permission` VALUES ('9303794a-1ee0-4ffb-8988-01d8f7539058', '1', '4');
INSERT INTO `role_permission` VALUES ('a7220fe0-d8d3-4a36-ab2b-e625a6619726', '227e6710-1666-4c90-9303-e5a0a0c7548e', '2');
INSERT INTO `role_permission` VALUES ('a7cb86c9-be1e-4ba6-b01d-4cde9d9ff972', '1', '69176a8d-28fd-4227-ac2c-c4ea9890e447');
INSERT INTO `role_permission` VALUES ('becaf494-1479-45f6-b19b-a918f4747ca4', '227e6710-1666-4c90-9303-e5a0a0c7548e', '3');
INSERT INTO `role_permission` VALUES ('c28b1e8c-6704-43fc-8988-84d04919ae78', '227e6710-1666-4c90-9303-e5a0a0c7548e', '368a69d8-81cd-4326-aec3-a305b7ae1594');
INSERT INTO `role_permission` VALUES ('c5002c56-995e-46a9-b4e9-b415f26895a7', '227e6710-1666-4c90-9303-e5a0a0c7548e', '1');
INSERT INTO `role_permission` VALUES ('d3fa2239-e597-46bb-ac0a-e175f059523f', '1', '1');
INSERT INTO `role_permission` VALUES ('f9c6cabc-efd5-4bb9-a0cd-e55368e33bef', '227e6710-1666-4c90-9303-e5a0a0c7548e', '69176a8d-28fd-4227-ac2c-c4ea9890e447');

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
INSERT INTO `user` VALUES ('2', 'ceshi', 'ceshi', '2021-08-02 05:58:56', '2022-05-10 07:21:52', NULL, NULL);
INSERT INTO `user` VALUES ('3', 'admin', 'admin', '2021-08-02 06:44:08', '2022-05-10 02:46:37', NULL, NULL);
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
INSERT INTO `user_role` VALUES ('3dcadb60-25ad-453c-96c5-0a2b3acb62c5', '3', '227e6710-1666-4c90-9303-e5a0a0c7548e');
INSERT INTO `user_role` VALUES ('3dcd3cd7-3126-420d-903b-c1bd5a99fc38', '3', '1');
INSERT INTO `user_role` VALUES ('4', '4', '1');
INSERT INTO `user_role` VALUES ('55fff5b2-7389-462b-9db4-6e643e4cc2fd', '1', '227e6710-1666-4c90-9303-e5a0a0c7548e');
INSERT INTO `user_role` VALUES ('62a60335-0ed9-49df-bc50-b6daaeb6c5f1', '1', '1');
INSERT INTO `user_role` VALUES ('b74cf6f0-caa8-4362-95c7-4b16b84e40d1', '2', '1');

SET FOREIGN_KEY_CHECKS = 1;
