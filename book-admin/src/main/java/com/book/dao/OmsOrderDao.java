package com.book.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.entity.OmsOrder;
import org.springframework.stereotype.Repository;

/**
 * 订单表(OmsOrder)表数据库访问层
 *
 * @author makejava
 * @since 2024-07-25 14:38:38
 */
@Repository
public interface OmsOrderDao extends BaseMapper<OmsOrder> {

}

