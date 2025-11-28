package com.book.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 角色资源表，存储角色所拥有的资源或者权限(RolePermission)表实体类
 *
 * @author jojo思密达
 * @since 2025-11-27 17:28:04
 */
@SuppressWarnings("serial")
public class RolePermission extends Model<RolePermission> {
    /**
     * 角色ID     
     */
    private Long roleId;
    /**
     * 权限ID     
     */
    private Long permissionId;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.roleId;
    }
}

