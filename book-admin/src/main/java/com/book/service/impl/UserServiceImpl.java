package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.UserDao;
import com.book.entity.User;
import com.book.service.UserService;
import org.springframework.stereotype.Service;

/**
 * (User)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-04-15 12:31:34
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

}

