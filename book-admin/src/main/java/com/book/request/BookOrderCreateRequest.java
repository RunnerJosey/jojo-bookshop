package com.book.request;

import java.io.Serializable;
import java.util.List;

/**
 * 创建订单（下单）请求
 *
 * @author jojo思密达
 * @since 2026-09-23
 */
public class BookOrderCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 待下单的购物车项ID集合
     */
    private List<Long> cartItemIds;

    /**
     * 支付方式：1-微信 2-支付宝 3-线下支付
     */
    private Integer payType;

    /**
     * 收货地址ID
     */
    private Long addressId;


    public List<Long> getCartItemIds() {
        return cartItemIds;
    }

    public void setCartItemIds(List<Long> cartItemIds) {
        this.cartItemIds = cartItemIds;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}
