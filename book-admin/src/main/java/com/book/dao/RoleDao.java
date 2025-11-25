package com.book.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 角色表，存放角色名称(Role)表数据库访问层
 *
 * @author jojo思密达
 * @since 2025-11-24 15:31:25
 */
public interface RoleDao extends BaseMapper<Role> {

    @Select("select * from role r " +
            "left join user_role ur on ur.role_id = r.id where ur.user_id in #{id}")
    List<Role> selectRolesByUserIds(List<Long> userIds);

    @Select("select r.role_name from role r " +
            "left join user_role ur on ur.role_id = r.id where ur.user_id = #{id}")
    List<String> selectRoles(Long id);
}

