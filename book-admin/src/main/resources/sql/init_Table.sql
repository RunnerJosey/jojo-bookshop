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
    `is_delete` tinyint NOT NULL DEFAULT (0) COMMENT '是否删除',
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci AVG_ROW_LENGTH=1 ROW_FORMAT=COMPRESSED;

-- 正在导出表  bookshop.book 的数据：~11 rows (大约)
INSERT INTO `book` (`id`, `book_name`, `introduce`, `author`, `creater`, `create_time`, `updater`, `update_time`, `is_delete`) VALUES
                                                                                                                                   (1, '三国演绎', '桃园三结义', '罗贯中', 'Josey16', '2025-04-14 12:12:26', 'Josey', '2025-04-14 12:12:32', 0),
                                                                                                                                   (3, '卖包子的小蘑菇', '啦啦啦', 'ffff', 'jojo', '2025-05-08 09:19:18', '', '2025-05-08 09:19:18', 0),
                                                                                                                                   (7, '天天消消乐', '收到324342342', 'jackfasdfa', 'jojo', '2025-05-08 15:02:15', '', '2025-05-08 15:02:15', 0),
                                                                                                                                   (8, '今晚打老虎', 'fsadf', 'dsafs', 'sdaf', '2025-05-08 15:12:11', '', '2025-05-08 15:12:11', 0),
                                                                                                                                   (9, '无巧不成书', 'dsaf', 'sdaf', 'sfas', '2025-05-08 15:12:18', '', '2025-05-08 15:12:18', 0),
                                                                                                                                   (10, '天元突破', 'sfa', 'safa', 'safas', '2025-05-08 15:12:25', '', '2025-05-08 15:12:25', 0),
                                                                                                                                   (11, '原本是一家', 'asdf', 'asfda', 'safdas', '2025-05-08 15:12:32', '', '2025-05-08 15:12:32', 0),
                                                                                                                                   (12, '咒术回战', 'afdas', 'sadfa', 'safdas', '2025-05-08 15:12:38', '', '2025-05-08 15:12:38', 0),
                                                                                                                                   (13, '今天一起包饺砸', '发大水', '发射点发生', '而我却发撒从', '2025-09-17 09:29:20', '', '2025-09-17 09:29:20', 0),
                                                                                                                                   (15, '侠客行', '阿利法', '金庸', 'jojo', '2025-11-20 17:49:51', '', '2025-11-20 17:49:51', 0),
                                                                                                                                   (16, '狗哥的一生', 'fasdf', 'afdas', 'afs', '2025-11-20 17:50:31', '', '2025-11-20 17:50:31', 0);

-- 导出  表 bookshop.book_order 结构
CREATE TABLE IF NOT EXISTS `book_order` (
                                            `order_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单编号（主键，规则：时间戳+随机数，如202512041000001234）',
                                            `user_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '下单用户ID（关联用户表user_id）',
    `order_status` tinyint NOT NULL DEFAULT '0' COMMENT '订单状态：0-待付款 1-待发货 2-待收货 3-已完成 4-已取消 5-退款中 6-已退款',
    `cart_item_id` bigint NOT NULL DEFAULT (0) COMMENT '关联的购物车id',
    `discount_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '优惠金额（优惠券+满减等）',
    `freight` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '运费（满额包邮则为0）',
    `total_amount` decimal(10,2) NOT NULL COMMENT '订单总金额（所有图书金额之和）',
    `pay_type` tinyint DEFAULT NULL COMMENT '支付方式：1-微信 2-支付宝 3-线下支付',
    `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '实际支付金额（扣除优惠券/满减后）',
    `pay_time` datetime DEFAULT NULL COMMENT '支付时间（未支付则为NULL）',
    `address_id` bigint NOT NULL DEFAULT (0) COMMENT '收货地址id',
    `consignee_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '收货人姓名',
    `consignee_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '收货人电话',
    `address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '收货地址',
    `cancel_reason` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '取消原因（仅状态为4时填写）',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '订单创建时间',
    `creater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'CURRENT_TIMESTAMP' COMMENT '订单创建人',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '订单更新时间',
    `updater` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'CURRENT_TIMESTAMP' COMMENT '更新者',
    `is_delete` tinyint NOT NULL DEFAULT (0) COMMENT '是否删除',
    PRIMARY KEY (`order_id`),
    KEY `idx_user_id` (`user_id`) COMMENT '按用户ID查询订单的索引',
    KEY `idx_order_status` (`order_status`) COMMENT '按订单状态筛选的索引',
    KEY `idx_create_time` (`create_time`) COMMENT '按创建时间查询的索引'
    ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='书店订单主表';

-- 正在导出表  bookshop.book_order 的数据：~3 rows (大约)
INSERT INTO `book_order` (`order_id`, `user_id`, `order_status`, `cart_item_id`, `discount_amount`, `freight`, `total_amount`, `pay_type`, `pay_amount`, `pay_time`, `address_id`, `consignee_name`, `consignee_phone`, `address`, `cancel_reason`, `create_time`, `creater`, `update_time`, `updater`, `is_delete`) VALUES
                                                                                                                                                                                                                                                                                                                         (1, '2', 0, 0, 0.00, 0.00, 1.00, 1, 1.00, NULL, 2, '蜗牛', '18320187777', '天津市天津市和平区f阿萨', NULL, '2025-12-17 10:22:24', 'admin', '2025-12-17 10:22:24', 'CURRENT_TIMESTAMP', 0),
                                                                                                                                                                                                                                                                                                                         (2, '2', 0, 0, 0.00, 0.00, 1.00, 1, 1.00, NULL, 2000841492489428994, '小明', '12244443333', '福建省福州市鼓楼区发送', NULL, '2025-12-17 11:07:50', 'admin', '2025-12-17 11:07:50', 'CURRENT_TIMESTAMP', 0),
                                                                                                                                                                                                                                                                                                                         (3, '2', 0, 2000824113789218817, 0.00, 0.00, 1.00, 1, 1.00, NULL, 2, '蜗牛', '18320187777', '天津市天津市和平区f阿萨', NULL, '2025-12-17 11:13:32', 'admin', '2025-12-17 11:13:32', 'CURRENT_TIMESTAMP', 0);

-- 导出  表 bookshop.book_order_item 结构
CREATE TABLE IF NOT EXISTS `book_order_item` (
                                                 `item_id` bigint NOT NULL AUTO_INCREMENT COMMENT '明细ID（主键）',
                                                 `order_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '关联订单主表ID',
    `isbn` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图书ISBN编码（关联图书表isbn）',
    `book_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '图书名称（冗余存储，避免图书表修改后订单名称变化）',
    `book_price` decimal(10,2) NOT NULL COMMENT '图书单价（下单时的价格，冗余存储）',
    `quantity` int NOT NULL COMMENT '购买数量',
    `subtotal` decimal(10,2) NOT NULL COMMENT '该图书小计金额（book_price * quantity）',
    `discount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '该图书单独优惠金额（如单本折扣）',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '明细创建时间',
    `creater` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    `updater` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新人',
    `is_delete` tinyint DEFAULT NULL COMMENT '是否删除',
    PRIMARY KEY (`item_id`),
    KEY `idx_order_id` (`order_id`) COMMENT '按订单ID查询明细的索引',
    KEY `idx_isbn` (`isbn`) COMMENT '按ISBN查询图书订单的索引'
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='书店订单明细表';

-- 正在导出表  bookshop.book_order_item 的数据：~0 rows (大约)

-- 导出  表 bookshop.book_order_pay 结构
CREATE TABLE IF NOT EXISTS `book_order_pay` (
                                                `pay_id` bigint NOT NULL AUTO_INCREMENT COMMENT '支付记录ID（主键）',
                                                `order_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '关联订单ID',
    `pay_no` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '第三方支付流水号（微信/支付宝返回）',
    `pay_status` tinyint NOT NULL DEFAULT '0' COMMENT '支付状态：0-支付中 1-支付成功 2-支付失败',
    `pay_amount` decimal(10,2) NOT NULL COMMENT '支付金额',
    `pay_time` datetime DEFAULT NULL COMMENT '支付完成时间',
    `refund_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '退款金额（未退款则为0）',
    `refund_time` datetime DEFAULT NULL COMMENT '退款时间',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '支付记录创建时间',
    `creater` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'CURRENT_TIMESTAMP' COMMENT '创建者',
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '支付记录更新时间',
    `updater` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'CURRENT_TIMESTAMP' COMMENT '更新者',
    `is_delete` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'CURRENT_TIMESTAMP' COMMENT '是否删除',
    PRIMARY KEY (`pay_id`),
    KEY `idx_order_id` (`order_id`) COMMENT '按订单ID查询支付记录的索引',
    KEY `idx_pay_no` (`pay_no`) COMMENT '按第三方流水号对账的索引'
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='书店订单支付记录表';

-- 正在导出表  bookshop.book_order_pay 的数据：~0 rows (大约)

-- 导出  表 bookshop.book_order_refund 结构
CREATE TABLE IF NOT EXISTS `book_order_refund` (
    `refund_id` varchar(32) NOT NULL COMMENT '退款单ID',
    `pay_id` varchar(32) NOT NULL COMMENT '关联支付单ID',
    `order_id` varchar(32) NOT NULL COMMENT '关联订单ID',
    `refund_amount` decimal(10,2) NOT NULL COMMENT '退款金额',
    `refund_status` tinyint NOT NULL DEFAULT '0' COMMENT '0-待退款 1-退款中 2-退款成功 3-退款失败',
    `channel_refund_no` varchar(64) DEFAULT NULL COMMENT '渠道侧退款单号',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`refund_id`),
    KEY `idx_pay_id` (`pay_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='书店退款单表';

-- 正在导出表  bookshop.book_order_refund 的数据：~0 rows (大约)

-- 导出  表 bookshop.book_pay_log 结构
CREATE TABLE IF NOT EXISTS `book_pay_log` (
    `log_id` varchar(32) NOT NULL COMMENT '日志ID',
    `pay_id` varchar(32) NOT NULL COMMENT '支付单ID',
    `oper_type` varchar(20) NOT NULL COMMENT '操作类型：create_pay、call_channel、callback、query_pay',
    `content` text NOT NULL COMMENT '操作内容（请求/响应参数）',
    `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`log_id`),
    KEY `idx_pay_id` (`pay_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='书店支付日志表';

-- 正在导出表  bookshop.book_pay_log 的数据：~0 rows (大约)

-- 导出  表 bookshop.cart_item 结构
CREATE TABLE IF NOT EXISTS `cart_item` (
                                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                           `user_id` bigint NOT NULL COMMENT '用户ID',
                                           `book_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书籍SKU ID',
    `book_name` varchar(50) NOT NULL COMMENT '书籍名称',
    `spec_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '书籍规格ID',
    `spec_name` varchar(32) NOT NULL COMMENT '书籍规格',
    `quantity` int NOT NULL DEFAULT '1' COMMENT '书籍数量',
    `price` decimal(10,2) NOT NULL COMMENT '加购时单价',
    `selected` tinyint NOT NULL DEFAULT '1' COMMENT '是否选中（1=是，0=否）',
    `add_time` datetime NOT NULL COMMENT '加购时间',
    `update_time` datetime NOT NULL COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除（1=删除，0=正常）',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_sku_spec` (`user_id`,`book_id`,`spec_id`) USING BTREE COMMENT '避免重复加购同一商品同一规格',
    KEY `idx_user_id` (`user_id`) COMMENT '用户维度查询索引'
    ) ENGINE=InnoDB AUTO_INCREMENT=2000824129865986051 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='购物车表';

-- 正在导出表  bookshop.cart_item 的数据：~1 rows (大约)
INSERT INTO `cart_item` (`id`, `user_id`, `book_id`, `book_name`, `spec_id`, `spec_name`, `quantity`, `price`, `selected`, `add_time`, `update_time`, `is_deleted`) VALUES
    (2000824129865986050, 2, '8', '今晚打老虎', '1', '默认规格', 2, 1.00, 0, '2025-12-16 15:03:41', '2025-12-16 15:03:41', 1);

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
                                                                                                                                                                                  (2, 'admin', '$2a$10$WxA0SFIEkpEVYVP6PvD6ruNenucPy0OmvbhJDP6kLv9jExwx3lqke', '1', '18688888888', '123456@163.com', '1990-03-09', 'jojo', NULL, 'admin', '2025-11-20 09:10:07', NULL, NULL, ''),
                                                                                                                                                                                  (3, 'jerry', '$2a$10$J6TofgSebiL9ucM/.8ydaOE06NW8OO46.pX5Nw3Hdv7J0hb9JYmqi', '1', '13766665555', 'afasfa@163.com', '2025-11-04', '马可波罗', NULL, 'fasdfa', '2025-11-27 11:26:38', NULL, NULL, '0'),
                                                                                                                                                                                  (1994317952680263682, 'monkeyGoGO', '$2a$10$eBwYLH9ENl7wfSM3M8nLFe1cFZ9bbgQ5uAt1KgwIHsXPIHsW03qHu', '1', '15677773333', 'asdafasfd', '2025-11-05', '猴赛雷', NULL, 'fasdfa', '2025-11-28 16:10:27', NULL, NULL, '0'),
                                                                                                                                                                                  (1994322214101516290, 'josey', '$2a$10$E0fXGDw5wtaM5FOZufK4w.tr4ax/HSwesUKJAM4QbWtkPC5mtnjRS', '1', '13244445555', 'fasfa', '2025-11-19', '蜗牛大哥', NULL, 'fasdfasdfas', '2025-11-28 16:27:23', NULL, NULL, '0');

-- 导出  表 bookshop.user_address 结构
CREATE TABLE IF NOT EXISTS `user_address` (
                                              `address_id` bigint NOT NULL AUTO_INCREMENT COMMENT '地址ID（主键，规则：时间戳+随机数）',
                                              `user_id` bigint NOT NULL DEFAULT (0) COMMENT '关联用户ID（外键，关联用户表）',
    `consignee_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '收货人姓名',
    `consignee_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '收货人手机号（需做脱敏存储，如138****1234）',
    `province_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '省份名称（冗余存储，如广东省）',
    `city_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '城市名称（如广州市）',
    `district_name` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '区县名称（如天河区）',
    `detail_address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '详细地址（如XX街道XX小区XX栋XX单元）',
    `address_label` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址标签（如家庭、公司、学校）',
    `is_default` tinyint NOT NULL DEFAULT '0' COMMENT '是否默认地址：0-否 1-是（一个用户仅能有一个默认地址）',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '更新时间',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除：0-未删除 1-已删除',
    PRIMARY KEY (`address_id`),
    KEY `idx_user_id` (`user_id`) COMMENT '按用户ID查询地址的索引',
    KEY `idx_is_default` (`is_default`) COMMENT '查询默认地址的索引'
    ) ENGINE=InnoDB AUTO_INCREMENT=2000841492489428995 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='书店用户收货地址表';

-- 正在导出表  bookshop.user_address 的数据：~3 rows (大约)
INSERT INTO `user_address` (`address_id`, `user_id`, `consignee_name`, `consignee_phone`, `province_name`, `city_name`, `district_name`, `detail_address`, `address_label`, `is_default`, `create_time`, `update_time`, `is_deleted`) VALUES
                                                                                                                                                                                                                                          (2, 2, '蜗牛', '18320187777', '天津市', '天津市', '和平区', 'f阿萨', '11', 1, '2025-12-16 15:42:40', '2025-12-16 15:42:40', 0),
                                                                                                                                                                                                                                          (2000841360821837825, 2, '蜗牛哥', '18320181107', '广东省', '广州市', '天河区', '员村一横路7号大院', '家', 0, '2025-12-16 16:12:09', '2025-12-16 16:12:09', 0),
                                                                                                                                                                                                                                          (2000841492489428994, 2, '小明', '12244443333', '福建省', '福州市', '鼓楼区', '发送', '发', 0, '2025-12-16 16:12:40', '2025-12-16 16:12:40', 0);

-- 导出  表 bookshop.user_role 结构
CREATE TABLE IF NOT EXISTS `user_role` (
                                           `user_id` bigint NOT NULL COMMENT '用户ID',
                                           `role_id` bigint NOT NULL COMMENT '角色ID',
                                           PRIMARY KEY (`user_id`,`role_id`),
    KEY `role_id` (`role_id`),
    CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色关联表，关联用户和角色，多对多关系';

-- 正在导出表  bookshop.user_role 的数据：~6 rows (大约)
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
                                                   (1, 1),
                                                   (2, 1),
                                                   (1994317952680263682, 1),
                                                   (1994322214101516290, 1),
                                                   (1, 2),
                                                   (3, 2);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
