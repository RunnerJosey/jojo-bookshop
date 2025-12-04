package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.OrderDao;
import com.book.entity.Order;
import com.book.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * 书店订单主表(Order)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-12-04 16:46:41
 */
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

}

