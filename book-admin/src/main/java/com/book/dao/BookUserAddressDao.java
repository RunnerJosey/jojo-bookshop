package com.book.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.entity.BookUserAddress;
import org.apache.ibatis.annotations.Mapper;

/**
 * 书店用户收货地址表(BookUserAddress)表数据库访问层
 *
 * @author jojo思密达
 * @since 2025-12-08 17:46:05
 */
@Mapper
public interface BookUserAddressDao extends BaseMapper<BookUserAddress> {



}

