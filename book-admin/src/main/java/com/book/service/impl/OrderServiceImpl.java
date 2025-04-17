package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.OrderDao;
import com.book.entity.Order;
import com.book.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * (Order)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-04-15 12:31:55
 */
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {

}

