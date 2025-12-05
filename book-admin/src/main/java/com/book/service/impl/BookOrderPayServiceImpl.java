package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.BookOrderPayDao;
import com.book.entity.BookOrderPay;
import com.book.service.BookOrderPayService;
import org.springframework.stereotype.Service;

/**
 * 书店订单支付记录表(BookOrderPay)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-12-05 10:31:54
 */
@Service("bookOrderPayService")
public class BookOrderPayServiceImpl extends ServiceImpl<BookOrderPayDao, BookOrderPay> implements BookOrderPayService {

}

