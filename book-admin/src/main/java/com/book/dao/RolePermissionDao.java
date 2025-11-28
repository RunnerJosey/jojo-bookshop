package com.book.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.entity.RolePermission;

/**
 * 角色资源表，存储角色所拥有的资源或者权限(RolePermission)表数据库访问层
 *
 * @author jojo思密达
 * @since 2025-11-27 17:28:04
 */
public interface RolePermissionDao extends BaseMapper<RolePermission> {

}

