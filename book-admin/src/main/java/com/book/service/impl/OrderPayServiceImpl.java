package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.OrderPayDao;
import com.book.entity.OrderPay;
import com.book.service.OrderPayService;
import org.springframework.stereotype.Service;

/**
 * 书店订单支付记录表(OrderPay)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-12-04 16:46:42
 */
@Service("orderPayService")
public class OrderPayServiceImpl extends ServiceImpl<OrderPayDao, OrderPay> implements OrderPayService {

}

