
create database `lb-wallpaper` character set utf8mb4;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for adv_trigger_record
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`adv_trigger_record`;
CREATE TABLE `lb-wallpaper`.`adv_trigger_record`  (
                                       `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                       `adv_id` bigint NOT NULL COMMENT '广告ID',
                                       `trigger_type` tinyint NOT NULL COMMENT '广告触发类型：1：广告展示，2：广告播放，3：广告点击',
                                       `create_time` datetime NOT NULL COMMENT '创建时间',
                                       PRIMARY KEY (`id`) USING BTREE,
                                       INDEX `idx_adv_id`(`adv_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 153 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '广告触发记录表' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for advertising
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`advertising`;
CREATE TABLE `lb-wallpaper`.`advertising`  (
                                `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                `adv_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '广告名称',
                                `contents_type` tinyint NOT NULL COMMENT '广告内容类型 1.图片；2.视频',
                                `adv_contents` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '广告内容 图片或视频',
                                `url_type` tinyint NOT NULL COMMENT '广告跳转路径类型 1.广告链接；',
                                `adv_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '广告跳转路径',
                                `adv_desc` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '广告描述',
                                `create_time` datetime NOT NULL COMMENT '创建时间',
                                `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                                `create_id` bigint NOT NULL COMMENT '创建人ID',
                                `update_id` bigint NULL DEFAULT NULL COMMENT '修改人ID',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '广告信息表' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`category`;
CREATE TABLE `lb-wallpaper`.`category`  (
                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                             `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '分类名称',
                             `details` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '详细信息',
                             `create_time` datetime NOT NULL COMMENT '创建时间',
                             `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                             `create_id` bigint NOT NULL COMMENT '创建人ID',
                             `update_id` bigint NULL DEFAULT NULL COMMENT '修改人ID',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `lb-wallpaper`.`category` VALUES (1, '风景', '测试数据', '2024-03-07 14:00:21', '2024-03-07 14:00:23', 1, 1);
INSERT INTO `lb-wallpaper`.`category` VALUES (2, '汽车', '测试数据', '2024-03-07 15:03:56', '2024-03-07 15:04:32', 1, 1);

-- ----------------------------
-- Table structure for consumer_user
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`consumer_user`;
CREATE TABLE `lb-wallpaper`.`consumer_user`  (
                                  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
                                  `nickname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
                                  `head_img` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
                                  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户手机号',
                                  `password` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
                                  `register_time` datetime NOT NULL COMMENT '注册时间',
                                  `recent_login_time` datetime NULL DEFAULT NULL COMMENT '最近登录时间',
                                  `gender` tinyint NULL DEFAULT NULL COMMENT '性别，1：男，2：女',
                                  `birthday` date NULL DEFAULT NULL COMMENT '生日',
                                  `signature` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '签名',
                                  PRIMARY KEY (`id`) USING BTREE,
                                  UNIQUE INDEX `uidx_phone`(`phone` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consumer_user
-- ----------------------------
INSERT INTO `lb-wallpaper`.`consumer_user` VALUES (1, '聪明的飞机哈哈哈', 'http://192.168.0.27:8081/lb-wallpaper-java/image/2024/03/28/20240328101047944-1.jpg', '18569542414', '25f9e794323b453885f5181f1b624d0b', '2024-03-16 16:00:02', '2024-03-29 11:17:58', 0, '2024-03-27', 'Lorem et reprehenderit eu nullaaaa');

-- ----------------------------
-- Table structure for download_record
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`download_record`;
CREATE TABLE `lb-wallpaper`.`download_record`  (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                    `user_id` bigint NOT NULL COMMENT '用户ID',
                                    `wallpaper_id` bigint NOT NULL COMMENT '壁纸ID',
                                    `create_time` datetime NOT NULL COMMENT '创建时间',
                                    PRIMARY KEY (`id`) USING BTREE,
                                    INDEX `idx_user_id`(`user_id` ASC) USING BTREE,
                                    INDEX `idx_wallpaper_id`(`wallpaper_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '壁纸下载记录表' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for favorites
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`favorites`;
CREATE TABLE `lb-wallpaper`.`favorites`  (
                              `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                              `user_id` bigint NOT NULL COMMENT '用户ID',
                              `title` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '收藏夹名称',
                              `favorites_desc` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收藏夹描述',
                              `create_time` datetime NOT NULL COMMENT '创建时间',
                              PRIMARY KEY (`id`) USING BTREE,
                              INDEX `idx_user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户收藏夹' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for feedback_record
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`feedback_record`;
CREATE TABLE `lb-wallpaper`.`feedback_record`  (
                                    `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                    `feedback_type` tinyint NOT NULL COMMENT '反馈类型，1：问题，2：建议',
                                    `feedback_content` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '反馈内容',
                                    `feedback_img_list` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '反馈的图片，数组格式字符串',
                                    `user_id` bigint NOT NULL COMMENT '用户ID',
                                    `create_time` datetime NOT NULL COMMENT '创建时间',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户反馈记录' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`sys_menu`;
CREATE TABLE `lb-wallpaper`.`sys_menu`  (
                             `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                             `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限名称',
                             `type` tinyint NOT NULL COMMENT '权限类型：1:目录，2：菜单，3：按钮',
                             `parent_id` int NOT NULL DEFAULT 0 COMMENT '父级权限ID',
                             `path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '路由地址',
                             `component` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组件路径',
                             `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '菜单图标',
                             `sort` int NULL DEFAULT NULL COMMENT '显示顺序',
                             `hidden` tinyint NOT NULL DEFAULT 0 COMMENT '是否隐藏：0：否，1：是',
                             PRIMARY KEY (`id`) USING BTREE,
                             INDEX `idx_type`(`type` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '权限表（包含菜单及按钮）' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (18, '系统管理', 1, -1, '/system', NULL, 'el-icon-setting', 99, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (19, '菜单管理', 2, 18, '/sysMenuManage', '/system/SysMenuManage', 'el-icon-menu', 1, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (22, '用户管理', 2, 18, '/sysUser', '/system/SysUserManage', 'el-icon-user', 2, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (23, '角色管理', 2, 18, '/roleManage', '/system/SysRoleManage', 'el-icon-s-custom', 3, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (24, '添加用户', 3, 22, '', 'addUser', '', 1, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (25, '修改用户', 3, 22, '', 'editUser', '', 2, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (26, '修改密码', 3, 22, '', 'updatePassword', '', 3, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (27, '删除用户', 3, 22, '', 'deleteUser', '', 4, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (28, '添加角色', 3, 23, '', 'addRole', '', 1, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (29, '修改角色', 3, 23, '', 'editRole', '', 2, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (30, '删除角色', 3, 23, '', 'deleteRole', '', 3, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (31, '分类管理', 2, -1, '/categoryManage', '/categoryManage/CategoryManage', 'el-icon-menu', 3, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (32, '壁纸管理', 2, -1, '/wallpaperManage', '/wallpaperManage/WallpaperManage', 'el-icon-picture', 1, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (33, '广告管理', 2, -1, '/advertisingManage', '/advertisingManage/AdvertisingManage', 'el-icon-setting', 2, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (34, '添加广告', 3, 33, '', 'addAdv', '', 1, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (35, '修改广告', 3, 33, '', 'editAdv', '', 2, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (36, '删除广告', 3, 33, '', 'deleteAdv', '', 3, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (37, '新增分类', 3, 31, '', 'addCategory', '', 1, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (38, '修改分类', 3, 31, '', 'updateCategory', '', 2, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (39, '删除分类', 3, 31, '', 'deleteCategory', '', 3, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (40, '添加壁纸', 3, 32, '', 'addWallpaper', '', 1, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (41, '修改壁纸', 3, 32, '', 'updateWallpaper', '', 2, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (42, '删除壁纸', 3, 32, '', 'deleteWallpaper', '', 3, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` VALUES (43, '用户反馈', 2, -1, '/feedback', '/feedbackRecord/FeedbackRecordList', 'el-icon-message', 4, 0);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`sys_role`;
CREATE TABLE `lb-wallpaper`.`sys_role`  (
                             `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                             `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色名称',
                             `role_code` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '角色编码',
                             `role_describe` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`sys_role_menu`;
CREATE TABLE `lb-wallpaper`.`sys_role_menu`  (
                                  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                  `role_id` int NOT NULL COMMENT '角色ID',
                                  `menu_id` int NOT NULL COMMENT '权限（菜单或按钮）ID',
                                  PRIMARY KEY (`id`) USING BTREE,
                                  INDEX `idx_role_id`(`role_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '角色-权限关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`sys_user`;
CREATE TABLE `lb-wallpaper`.`sys_user`  (
                             `id` bigint NOT NULL COMMENT '用户ID',
                             `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名称',
                             `user_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像',
                             `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
                             `recent_login_time` datetime NULL DEFAULT NULL COMMENT '最近登录时间',
                             `create_id` int NULL DEFAULT NULL,
                             `create_time` datetime NULL DEFAULT NULL,
                             `update_id` int NULL DEFAULT NULL,
                             `update_time` datetime NULL DEFAULT NULL,
                             `role_id` int NULL DEFAULT NULL COMMENT '角色ID',
                             `channel_id` int NULL DEFAULT NULL COMMENT '渠道ID',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `lb-wallpaper`.`sys_user` VALUES (1, 'Admin', 'https://h5.cajbook.com/image/head/1.png', '96e79218965eb72c92a549dd5a330112', '2024-03-30 09:48:08', 0, '2023-11-10 11:51:26', 0, '2023-11-10 11:51:32', 1, 1);

-- ----------------------------
-- Table structure for wallpaper_collect_record
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`wallpaper_collect_record`;
CREATE TABLE `lb-wallpaper`.`wallpaper_collect_record`  (
                                             `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                             `wallpaper_id` bigint NOT NULL COMMENT '壁纸ID',
                                             `user_id` bigint NOT NULL COMMENT '用户ID',
                                             `favorites_id` bigint NULL DEFAULT NULL COMMENT '收藏夹ID',
                                             `create_time` datetime NOT NULL COMMENT '创建时间',
                                             PRIMARY KEY (`id`) USING BTREE,
                                             INDEX `idx_wallpaper_id`(`wallpaper_id` ASC) USING BTREE,
                                             INDEX `idx_user_id`(`user_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '壁纸收藏记录表' ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for wallpaper_info
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`wallpaper_info`;
CREATE TABLE `lb-wallpaper`.`wallpaper_info`  (
                                   `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                   `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '壁纸名称',
                                   `img_url_list` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '壁纸图片访问路径集合',
                                   `is_collection` tinyint NOT NULL COMMENT '是否为合集，0：否，1：是',
                                   `category_id` bigint NOT NULL COMMENT '分类ID',
                                   `details` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '详细介绍',
                                   `create_time` datetime NOT NULL COMMENT '创建时间',
                                   `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
                                   `create_id` bigint NOT NULL COMMENT '创建人ID',
                                   `update_id` bigint NULL DEFAULT NULL COMMENT '修改人ID',
                                   PRIMARY KEY (`id`) USING BTREE,
                                   INDEX `idx_category_id`(`category_id` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '壁纸信息表' ROW_FORMAT = Dynamic;


SET FOREIGN_KEY_CHECKS = 1;
