package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.BookOrderItemDao;
import com.book.entity.BookOrderItem;
import com.book.service.BookOrderItemService;
import org.springframework.stereotype.Service;

/**
 * 书店订单明细表(BookOrderItem)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-12-05 10:31:54
 */
@Service("bookOrderItemService")
public class BookOrderItemServiceImpl extends ServiceImpl<BookOrderItemDao, BookOrderItem> implements BookOrderItemService {

}

