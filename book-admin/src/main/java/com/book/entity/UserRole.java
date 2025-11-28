package com.book.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 用户角色关联表，关联用户和角色，多对多关系(UserRole)表实体类
 *
 * @author jojo思密达
 * @since 2025-11-27 17:27:34
 */
@SuppressWarnings("serial")
public class UserRole extends Model<UserRole> {
    /**
     * 用户ID     
     */
    private Long userId;
    /**
     * 角色ID     
     */
    private Long roleId;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}

