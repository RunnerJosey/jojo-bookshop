package com.book.enums;

import lombok.Data;

/**
 * 订单状态：0-待付款 1-待发货 2-待收货 3-已完成 4-已取消 5-退款中 6-已退款
 */
public enum OrderStatusEnum {
    WATING_FOR_PAYMENT(0 ,"待付款"),//创建订单未付款
    WATING_FOR_DELIVERY(1 ,"待发货"),//付款结束
    WATING_FOR_RECEIPT(2 ,"待收货"),//发货结束
    COMPLIETED(3 ,"已完成"),//收货结束
    CANCELLED(4 ,"已取消"),//取消订单
    REFUNDING(5 ,"退款中"),//退款中
    REFUNDED(6 ,"已退款");//退款结束


    private  Integer code;
    private  String name;

    OrderStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
