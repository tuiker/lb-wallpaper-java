
create database `lb-wallpaper` character set utf8mb4;

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
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '权限表（包含菜单及按钮）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `lb-wallpaper`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (18, '系统管理', 1, -1, '/system', NULL, 'el-icon-setting', 99, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (19, '菜单管理', 2, 18, '/sysMenuManage', '/system/SysMenuManage', 'el-icon-menu', 1, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (22, '用户管理', 2, 18, '/sysUser', '/system/SysUserManage', 'el-icon-user', 2, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (23, '角色管理', 2, 18, '/roleManage', '/system/SysRoleManage', 'el-icon-s-custom', 3, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (24, '添加用户', 3, 22, '', 'addUser', '', 1, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (25, '修改用户', 3, 22, '', 'editUser', '', 2, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (26, '修改密码', 3, 22, '', 'updatePassword', '', 3, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (27, '删除用户', 3, 22, '', 'deleteUser', '', 4, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (28, '添加角色', 3, 23, '', 'addRole', '', 1, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (29, '修改角色', 3, 23, '', 'editRole', '', 2, 0);
INSERT INTO `lb-wallpaper`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (30, '删除角色', 3, 23, '', 'deleteRole', '', 3, 0);




CREATE TABLE `lb-wallpaper`.`sys_role` (
                            `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                            `role_name` varchar(30) NOT NULL COMMENT '角色名称',
                            `role_code` varchar(30) NOT NULL COMMENT '角色编码',
                            `role_describe` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色信息表';



CREATE TABLE `lb-wallpaper`.`sys_role_menu` (
                                 `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                 `role_id` int NOT NULL COMMENT '角色ID',
                                 `menu_id` int NOT NULL COMMENT '权限（菜单或按钮）ID',
                                 PRIMARY KEY (`id`),
                                 KEY `idx_role_id` (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色-权限关联表';

-- ----------------------------
-- Records of sys_user_menu
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `lb-wallpaper`.`user_info`;
CREATE TABLE `lb-wallpaper`.`user_info`  (
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
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `lb-wallpaper`.`user_info` VALUES (1, 'Admin', 'https://h5.cajbook.com/image/head/1.png', '96e79218965eb72c92a549dd5a330112', '2023-12-04 13:14:27', 0, '2023-11-10 11:51:26', 0, '2023-11-10 11:51:32', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
