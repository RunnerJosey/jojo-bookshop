-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.34 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 导出  表 bookshop.book 结构
CREATE TABLE IF NOT EXISTS `book` (
                                      `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                                      `book_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '书名',
    `introduce` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '描述',
    `author` varchar(50) NOT NULL DEFAULT '' COMMENT '作者',
    `creater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `updater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
    `update_time` datetime NOT NULL COMMENT '更新时间',
    `is_delete` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '是否删除',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci AVG_ROW_LENGTH=1 ROW_FORMAT=COMPRESSED;

-- 正在导出表  bookshop.book 的数据：~11 rows (大约)
INSERT INTO `book` (`id`, `book_name`, `introduce`, `author`, `creater`, `create_time`, `updater`, `update_time`, `is_delete`) VALUES
                                                                                                                                   (1, '三国演绎', '桃园三结义', '罗贯中', 'Josey16', '2025-04-14 12:12:26', 'Josey', '2025-04-14 12:12:32', '0'),
                                                                                                                                   (3, '卖包子的小蘑菇', '啦啦啦', 'ffff', 'jojo', '2025-05-08 09:19:18', '', '2025-05-08 09:19:18', '0'),
                                                                                                                                   (7, '天天消消乐', '收到324342342', 'jackfasdfa', 'jojo', '2025-05-08 15:02:15', '', '2025-05-08 15:02:15', '0'),
                                                                                                                                   (8, '今晚打老虎', 'fsadf', 'dsafs', 'sdaf', '2025-05-08 15:12:11', '', '2025-05-08 15:12:11', '0'),
                                                                                                                                   (9, '无巧不成书', 'dsaf', 'sdaf', 'sfas', '2025-05-08 15:12:18', '', '2025-05-08 15:12:18', '0'),
                                                                                                                                   (10, '天元突破', 'sfa', 'safa', 'safas', '2025-05-08 15:12:25', '', '2025-05-08 15:12:25', '0'),
                                                                                                                                   (11, '原本是一家', 'asdf', 'asfda', 'safdas', '2025-05-08 15:12:32', '', '2025-05-08 15:12:32', '0'),
                                                                                                                                   (12, '咒术回战', 'afdas', 'sadfa', 'safdas', '2025-05-08 15:12:38', '', '2025-05-08 15:12:38', '0'),
                                                                                                                                   (13, '今天一起包饺砸', '发大水', '发射点发生', '而我却发撒从', '2025-09-17 09:29:20', '', '2025-09-17 09:29:20', '0'),
                                                                                                                                   (15, '侠客行', '阿利法', '金庸', 'jojo', '2025-11-20 17:49:51', '', '2025-11-20 17:49:51', '0'),
                                                                                                                                   (16, '狗哥的一生', 'fasdf', 'afdas', 'afs', '2025-11-20 17:50:31', '', '2025-11-20 17:50:31', '0');

-- 导出  表 bookshop.cart_item 结构
CREATE TABLE IF NOT EXISTS `cart_item` (
                                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                           `user_id` bigint NOT NULL COMMENT '用户ID',
                                           `book_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书籍SKU ID',
    `spec_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书籍规格ID',
    `quantity` int NOT NULL DEFAULT '1' COMMENT '书籍数量',
    `price` decimal(10,2) NOT NULL COMMENT '加购时单价',
    `selected` tinyint NOT NULL DEFAULT '1' COMMENT '是否选中（1=是，0=否）',
    `add_time` datetime NOT NULL COMMENT '加购时间',
    `update_time` datetime NOT NULL COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除（1=删除，0=正常）',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_sku_spec` (`user_id`,`book_id`,`spec_id`) USING BTREE COMMENT '避免重复加购同一商品同一规格',
    KEY `idx_user_id` (`user_id`) COMMENT '用户维度查询索引'
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='购物车表';

-- 正在导出表  bookshop.cart_item 的数据：~0 rows (大约)

-- 导出  表 bookshop.meal 结构
CREATE TABLE IF NOT EXISTS `meal` (
                                      `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
                                      `dishes_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '菜肴名字',
    `dishes_kind` varchar(50) DEFAULT NULL COMMENT '菜肴种类',
    `dishes_user` varchar(50) DEFAULT NULL COMMENT '菜肴使用者',
    `chose_count` int DEFAULT NULL COMMENT '出现次数',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `creater` varchar(50) DEFAULT NULL COMMENT '创建人',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `updater` varchar(50) DEFAULT NULL COMMENT '更新者',
    `is_delete` int DEFAULT NULL COMMENT '是否删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1676718083 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单表';

-- 正在导出表  bookshop.meal 的数据：~7 rows (大约)
INSERT INTO `meal` (`id`, `dishes_name`, `dishes_kind`, `dishes_user`, `chose_count`, `create_time`, `creater`, `update_time`, `updater`, `is_delete`) VALUES
                                                                                                                                                           (1, '老王牛肉面', '兰州拉面', 'josey', NULL, '2025-09-18 16:51:50', 'josey', '2025-09-18 16:51:52', 'josey', 0),
                                                                                                                                                           (2, '一品香', '老字号粤菜', 'josey', NULL, '2025-09-18 16:57:57', 'josey', '2025-09-18 16:57:58', 'josey', 0),
                                                                                                                                                           (3, '知味园', '自选称重快餐', 'josey', NULL, '2025-09-18 16:59:02', 'josey', '2025-09-18 16:59:02', 'josey', 0),
                                                                                                                                                           (4, '肯德基', '西式快餐', 'josey', NULL, '2025-09-18 17:14:20', 'josey', '2025-09-18 17:14:21', 'josey', 0),
                                                                                                                                                           (5, '筒骨粉', '潮汕风味粉面', 'josey', NULL, '2025-09-18 17:16:47', 'josey', '2025-09-18 17:16:45', 'josey', NULL),
                                                                                                                                                           (6, '猪脚饭', '潮汕猪脚饭', 'josey', NULL, '2025-09-18 17:16:48', 'josey', '2025-09-18 17:16:45', 'josey', NULL),
                                                                                                                                                           (7, '外卖', '平台经济', 'josey', NULL, '2025-09-18 17:16:48', 'josey', '2025-09-18 17:16:46', 'josey', NULL);

-- 导出  表 bookshop.order 结构
CREATE TABLE IF NOT EXISTS `order` (
                                       `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                                       `book_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '书名',
    `description` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '描述',
    `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '作者',
    `creater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '创建人',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `updater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '更新人',
    `update_time` datetime NOT NULL COMMENT '更新时间',
    `is_delete` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '是否删除',
    PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci AVG_ROW_LENGTH=1 ROW_FORMAT=COMPRESSED;

-- 正在导出表  bookshop.order 的数据：~0 rows (大约)

-- 导出  表 bookshop.permission 结构
CREATE TABLE IF NOT EXISTS `permission` (
                                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT '权限ID',
                                            `permission_name` varchar(50) NOT NULL COMMENT '权限名称（如：USER:READ）',
    `url` varchar(200) DEFAULT NULL COMMENT '关联接口路径',
    PRIMARY KEY (`id`),
    UNIQUE KEY `permission_name` (`permission_name`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='资源权限表，存放资源，例如接口访问路径，或者按钮点击权限';

-- 正在导出表  bookshop.permission 的数据：~0 rows (大约)
INSERT INTO `permission` (`id`, `permission_name`, `url`) VALUES
    (1, '人员管理接口', '/role/*');

-- 导出  表 bookshop.role 结构
CREATE TABLE IF NOT EXISTS `role` (
                                      `id` bigint NOT NULL AUTO_INCREMENT COMMENT '角色ID',
                                      `role_name` varchar(50) NOT NULL COMMENT '角色名称（如：ADMIN,USER）',
    `description` varchar(200) DEFAULT NULL COMMENT '角色描述',
    PRIMARY KEY (`id`),
    UNIQUE KEY `role_name` (`role_name`)
    ) ENGINE=InnoDB AUTO_INCREMENT=1994243936808407044 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表，存放角色名称';

-- 正在导出表  bookshop.role 的数据：~6 rows (大约)
INSERT INTO `role` (`id`, `role_name`, `description`) VALUES
                                                          (1, '管理员', '拥有所有权限'),
                                                          (2, '普通员工', '拥有部分权限'),
                                                          (1994238425069326338, '董事长', '董事会话事人，公司战略掌舵人'),
                                                          (1994238944600985601, 'CEO', '董事长的打工人'),
                                                          (1994243936808407042, '总裁', 'ceo的小马仔'),
                                                          (1994243936808407043, '牛马', '哞哞哞');

-- 导出  表 bookshop.role_permission 结构
CREATE TABLE IF NOT EXISTS `role_permission` (
                                                 `role_id` bigint NOT NULL COMMENT '角色ID',
                                                 `permission_id` bigint NOT NULL COMMENT '权限ID',
                                                 PRIMARY KEY (`role_id`,`permission_id`),
    KEY `permission_id` (`permission_id`),
    CONSTRAINT `role_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
    CONSTRAINT `role_permission_ibfk_2` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色资源表，存储角色所拥有的资源或者权限';

-- 正在导出表  bookshop.role_permission 的数据：~0 rows (大约)
INSERT INTO `role_permission` (`role_id`, `permission_id`) VALUES
    (1, 1);

-- 导出  表 bookshop.user 结构
CREATE TABLE IF NOT EXISTS `user` (
                                      `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
                                      `user_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '用户名',
    `password` varchar(120) NOT NULL,
    `sex` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
    `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号码',
    `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱',
    `birthday` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '生日',
    `nick_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '昵称',
    `memo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '备注',
    `creater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '创建人',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `updater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '更新人',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `is_delete` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '是否删除(0：否，1：是)',
    PRIMARY KEY (`id`) USING BTREE
    ) ENGINE=InnoDB AUTO_INCREMENT=1994322214101516291 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci AVG_ROW_LENGTH=1 ROW_FORMAT=COMPRESSED COMMENT='用户表，存储用户基本信息';

-- 正在导出表  bookshop.user 的数据：~5 rows (大约)
INSERT INTO `user` (`id`, `user_name`, `password`, `sex`, `phone`, `email`, `birthday`, `nick_name`, `memo`, `creater`, `create_time`, `updater`, `update_time`, `is_delete`) VALUES
                                                                                                                                                                                  (1, 'jojo', '', '1', '13820181108', 'oqiaoo@163.com', '1999-1-1', '蜗牛', '呜呜呜', 'josey', '2025-04-15 12:26:11', 'josey', '2025-04-15 12:26:18', '0'),
                                                                                                                                                                                  (2, 'admin', '$2a$10$WxA0SFIEkpEVYVP6PvD6ruNenucPy0OmvbhJDP6kLv9jExwx3lqke', '1', '18688888888', '123456@163.com', '1990-03-09', 'Jojo', NULL, 'admin', '2025-11-20 09:10:07', NULL, NULL, ''),
                                                                                                                                                                                  (3, '马克菠萝', '$2a$10$J6TofgSebiL9ucM/.8ydaOE06NW8OO46.pX5Nw3Hdv7J0hb9JYmqi', '1', '13766665555', 'afasfa@163.com', '2025-11-04', 'fasfa', NULL, 'fasdfa', '2025-11-27 11:26:38', NULL, NULL, '0'),
                                                                                                                                                                                  (1994317952680263682, 'fasdfa', '$2a$10$eBwYLH9ENl7wfSM3M8nLFe1cFZ9bbgQ5uAt1KgwIHsXPIHsW03qHu', '1', '15677773333', 'asdafasfd', '2025-11-05', '放大算法', NULL, 'fasdfa', '2025-11-28 16:10:27', NULL, NULL, '0'),
                                                                                                                                                                                  (1994322214101516290, 'fasdfasdfas', '$2a$10$E0fXGDw5wtaM5FOZufK4w.tr4ax/HSwesUKJAM4QbWtkPC5mtnjRS', '1', '13244445555', 'fasfa', '2025-11-19', 'fasd', NULL, 'fasdfasdfas', '2025-11-28 16:27:23', NULL, NULL, '0');

-- 导出  表 bookshop.user_role 结构
CREATE TABLE IF NOT EXISTS `user_role` (
                                           `user_id` bigint NOT NULL COMMENT '用户ID',
                                           `role_id` bigint NOT NULL COMMENT '角色ID',
                                           PRIMARY KEY (`user_id`,`role_id`),
    KEY `role_id` (`role_id`),
    CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色关联表，关联用户和角色，多对多关系';

-- 正在导出表  bookshop.user_role 的数据：~4 rows (大约)
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
                                                   (1, 1),
                                                   (2, 1),
                                                   (1, 2),
                                                   (3, 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
