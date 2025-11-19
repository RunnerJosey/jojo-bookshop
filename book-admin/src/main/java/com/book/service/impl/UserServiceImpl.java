package com.book.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.UserDao;
import com.book.entity.User;
import com.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-04-15 12:31:34
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService , UserDetailsService {

    @Autowired
    private UserDao userDao;

    /**
     * 根据用户名字查询用户
     * @param username
     * @return
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
        // 1. 从数据库查询用户
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        User user = userDao.selectList(queryWrapper).stream().findAny().get();

        //获取角色
        String role = "";
        List<String> roles = userDao.selectRoles(user.getId());
        if(CollectionUtil.isNotEmpty(roles)){
            role = roles.get(0);
        }

        // 2. 将自定义User转换为Spring Security的UserDetails
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUserName())
                .password(user.getPassword()) // 数据库中的密码应该是加密后的
                .roles(role) // 或者使用.authorities()，角色名字
                .accountExpired(false)//账户是否过期
                .accountLocked(false)//账户是否被锁定
                .credentialsExpired(false)//证书是否过期 ,
                .disabled(false)//账户是否被禁用  ,以上没有的字段都可以不设置
                .build();
    }

    @Override
    public boolean getUserByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        List<User> list = userDao.selectList(queryWrapper);
        if(CollectionUtil.isNotEmpty(list)){
            return false;
        }
        return true;
    }
}

