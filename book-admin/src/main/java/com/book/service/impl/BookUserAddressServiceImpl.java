package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.BookUserAddressDao;
import com.book.entity.BookUserAddress;
import com.book.service.BookUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 书店用户收货地址表(BookUserAddress)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-12-08 17:46:05
 */
@Service("bookUserAddressService")
public class BookUserAddressServiceImpl extends ServiceImpl<BookUserAddressDao, BookUserAddress> implements BookUserAddressService {

    @Autowired
    private BookUserAddressDao bookUserAddressDao;


    public boolean updateById(BookUserAddress bookUserAddress) {
        return bookUserAddressDao.updateById(bookUserAddress) == 1 ? true : false;
    }


}

