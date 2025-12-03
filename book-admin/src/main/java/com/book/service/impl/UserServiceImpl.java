package com.book.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.common.CommonResult;
import com.book.dao.RoleDao;
import com.book.dao.UserDao;
import com.book.dao.UserRoleDao;
import com.book.entity.Role;
import com.book.entity.User;
import com.book.entity.UserRole;
import com.book.exception.BusinessException;
import com.book.request.BasePageReq;
import com.book.request.UserRequest;
import com.book.response.UserResponse;
import com.book.service.UserRoleService;
import com.book.service.UserService;
import com.github.pagehelper.util.StringUtil;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserRoleService userRoleService;

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
        User user = userDao.selectList(queryWrapper).stream().findAny().orElse(null);
        // 检查用户是否存在
        if (user == null) {
            throw new BusinessException(10001,"用户不存在: " + username);
        }
        //获取角色
        String role = "";
        List<String> roles = roleDao.selectRoles(user.getId());
        if(CollectionUtil.isNotEmpty(roles)){
            role = roles.get(0);
        }
        if(StringUtil.isEmpty(role)){
//            throw new BusinessException(10002,"用户角色不存在: " + role);
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
    public boolean isExistUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username);
        List<User> list = userDao.selectList(queryWrapper);
        if(CollectionUtil.isNotEmpty(list)){
            return false;
        }
        return true;
    }

    @Override
    public Page<UserResponse> selectPage(Page<User> page, QueryWrapper<User> userQueryWrapper){
        Page<User> userPage = userDao.selectPage(page, userQueryWrapper);
        Page<UserResponse> userResponsePage = new Page<>();
        BeanUtils.copyProperties(userPage,userResponsePage);
        if(CollectionUtil.isEmpty(userPage.getRecords())){
            return userResponsePage;
        }
        List<UserResponse> responseList = userPage.getRecords().stream().map(user -> {
            UserResponse response = new UserResponse();
            BeanUtils.copyProperties(user, response);
            List<String> roles = roleDao.selectRoles(user.getId());
            if (CollectionUtil.isNotEmpty(roles)) {
                response.setRoles(roles);
            }
            return response;
        }).collect(Collectors.toList());
        userResponsePage.setRecords(responseList);
        return userResponsePage;

    }

    @Override
    public CommonResult updateUserAndRole(UserRequest request) {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", request.getId());
        // 只设置非空字段
        if (StringUtils.hasText(request.getUserName())) {
            updateWrapper.set("user_name", request.getUserName());
        }
        if (StringUtils.hasText(request.getNickName())) {
            updateWrapper.set("nick_name", request.getNickName());
        }
        if (StringUtils.hasText(request.getPhone())) {
            updateWrapper.set("phone", request.getPhone());
        }
        if (StringUtils.hasText(request.getEmail())) {
            updateWrapper.set("email", request.getEmail());
        }
        if (StringUtils.hasText(request.getBirthday())) {
            updateWrapper.set("birthday", request.getBirthday());
        }
        // 执行更新
        userDao.update(null, updateWrapper);

        //根据名字获取角色
        LambdaQueryWrapper<Role> roleQuery = new LambdaQueryWrapper<Role>();
        roleQuery.in(Role::getRoleName,request.getRoles());
        List<Role> roles = roleDao.selectList(roleQuery);
        if(userRoleService.lambdaQuery().eq(UserRole::getUserId, request.getId()).count() > 0){
            //删除当前用户的角色
            userRoleService.remove(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUserId, request.getId()));
        }
        if(CollectionUtil.isNotEmpty(roles)){
            List<UserRole> userRoleList = roles.stream().map(role -> {
                UserRole userRole = new UserRole();
                userRole.setUserId(request.getId());
                userRole.setRoleId(role.getId());
                return userRole;
            }).collect(Collectors.toList());
            //保存用户角色关系
            userRoleService.saveBatch(userRoleList);
        }
        return CommonResult.success("更新成功！");
    }

    @Override
    public User selectUserByUsername(String userName) {
        // 1. 从数据库查询用户
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,userName);
        User user = userDao.selectList(queryWrapper).stream().findAny().orElse(null);
        // 检查用户是否存在
        if (user == null) {
            throw new BusinessException(10001,"用户不存在: " + userName);
        }
        return user;
    }
}

