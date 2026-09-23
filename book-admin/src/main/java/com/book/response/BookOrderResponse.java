package com.book.response;

import com.book.entity.BookOrder;
import com.book.entity.BookOrderItem;

import java.io.Serializable;
import java.util.List;

/**
 * 订单详情响应（订单主表 + 明细列表）
 *
 * @author jojo思密达
 * @since 2026-09-23
 */
public class BookOrderResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单主表信息
     */
    private BookOrder order;

    /**
     * 订单明细列表
     */
    private List<BookOrderItem> itemList;


    public BookOrder getOrder() {
        return order;
    }

    public void setOrder(BookOrder order) {
        this.order = order;
    }

    public List<BookOrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<BookOrderItem> itemList) {
        this.itemList = itemList;
    }
}
