package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.OrderItemDao;
import com.book.entity.OrderItem;
import com.book.service.OrderItemService;
import org.springframework.stereotype.Service;

/**
 * 书店订单明细表(OrderItem)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-12-04 16:46:42
 */
@Service("orderItemService")
public class OrderItemServiceImpl extends ServiceImpl<OrderItemDao, OrderItem> implements OrderItemService {

}

