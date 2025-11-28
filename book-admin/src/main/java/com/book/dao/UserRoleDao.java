package com.book.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.entity.UserRole;

/**
 * 用户角色关联表，关联用户和角色，多对多关系(UserRole)表数据库访问层
 *
 * @author jojo思密达
 * @since 2025-11-27 17:27:34
 */
public interface UserRoleDao extends BaseMapper<UserRole> {

}

