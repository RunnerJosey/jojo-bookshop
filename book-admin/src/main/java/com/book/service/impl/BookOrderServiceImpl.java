package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.BookOrderDao;
import com.book.entity.BookOrder;
import com.book.service.BookOrderService;
import org.springframework.stereotype.Service;

/**
 * 书店订单主表(BookOrder)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-12-05 10:31:54
 */
@Service("bookOrderService")
public class BookOrderServiceImpl extends ServiceImpl<BookOrderDao, BookOrder> implements BookOrderService {

}

