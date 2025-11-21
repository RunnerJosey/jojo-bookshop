package com.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.book.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * (User)表服务接口
 *
 * @author jojo思密达
 * @since 2025-04-15 12:31:33
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户名字查询用户
     * @param username
     * @return
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    boolean isExistUsername(String username);
}

