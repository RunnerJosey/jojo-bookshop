package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.OmsOrderDao;
import com.book.entity.OmsOrder;
import com.book.service.OmsOrderService;
import org.springframework.stereotype.Service;

/**
 * 订单表(OmsOrder)表服务实现类
 *
 * @author makejava
 * @since 2024-07-25 14:38:40
 */
@Service("omsOrderService")
public class OmsOrderServiceImpl extends ServiceImpl<OmsOrderDao, OmsOrder> implements OmsOrderService {

}

