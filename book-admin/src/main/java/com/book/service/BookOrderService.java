package com.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.book.entity.BookOrder;
import com.book.request.BookOrderCreateRequest;

/**
 * 书店订单主表(BookOrder)表服务接口
 *
 * @author jojo思密达
 * @since 2025-12-05 10:31:54
 */
public interface BookOrderService extends IService<BookOrder> {

    /**
     * 下单：根据购物车项生成订单与订单明细，并清空对应购物车项
     *
     * @param userId  当前下单用户ID
     * @param request 下单请求（购物车项ID集合、支付方式、收货地址ID）
     * @return 生成的订单
     */
    BookOrder checkout(Long userId, BookOrderCreateRequest request);

}
