package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.UserAddressDao;
import com.book.entity.UserAddress;
import com.book.service.UserAddressService;
import org.springframework.stereotype.Service;

/**
 * 书店用户收货地址表(BookUserAddress)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-12-08 17:46:05
 */
@Service("bookUserAddressService")
public class UserAddressServiceImpl extends ServiceImpl<UserAddressDao, UserAddress> implements UserAddressService {

}
