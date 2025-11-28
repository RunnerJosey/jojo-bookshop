package com.book.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * 角色表，存放角色名称(Role)表实体类
 *
 * @author jojo思密达
 * @since 2025-11-25 09:02:04
 */
@SuppressWarnings("serial")
public class Role extends Model<Role> {
    /**
     * 角色ID     
     */
    @TableId(value = "id", type = IdType.AUTO)
    @JsonProperty("id")
    private Long id;
    /**
     * 角色名称（如：ADMIN,USER）     
     */
    private String roleName;
    /**
     * 角色描述     
     */
    private String description;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}

