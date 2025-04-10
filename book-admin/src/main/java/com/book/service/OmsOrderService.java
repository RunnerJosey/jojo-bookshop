package com.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.book.config.utils.ThreadPoolUtils;
import com.book.entity.OmsOrder;
import com.book.utils.ThreadPoolUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 订单表(OmsOrder)表服务接口
 *
 * @author makejava
 * @since 2024-07-25 14:38:40
 */
public interface OmsOrderService extends IService<OmsOrder> {




}

