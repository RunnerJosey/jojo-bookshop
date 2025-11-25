package com.book.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author jojo思密达
 * @since 2025-04-15 12:31:32
 */
public interface UserDao extends BaseMapper<User> {


}

