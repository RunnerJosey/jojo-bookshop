package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.BookDao;
import com.book.entity.Book;
import com.book.service.BookService;
import org.springframework.stereotype.Service;

/**
 * (Book)表服务实现类
 *
 * @author makejava
 * @since 2025-04-11 10:41:29
 */
@Service("bookService")
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {

}

