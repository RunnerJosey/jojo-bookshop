package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.BookDao;
import com.book.entity.Book;
import com.book.service.BookService;
import org.springframework.stereotype.Service;

/**
 * (Book)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-04-17 19:48:44
 */
@Service("bookService")
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {

}

