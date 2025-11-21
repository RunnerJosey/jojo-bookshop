package com.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.book.entity.Book;

/**
 * (Book)表服务接口
 *
 * @author jojo思密达
 * @since 2025-04-17 19:48:44
 */
public interface BookService extends IService<Book> {

    public boolean save(Book book);

    public Book getById(Long id);
}

