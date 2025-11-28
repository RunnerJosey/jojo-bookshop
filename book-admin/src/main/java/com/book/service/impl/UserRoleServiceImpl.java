package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.UserRoleDao;
import com.book.entity.UserRole;
import com.book.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * 用户角色关联表，关联用户和角色，多对多关系(UserRole)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-11-27 17:56:43
 */
@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRole> implements UserRoleService {

}

