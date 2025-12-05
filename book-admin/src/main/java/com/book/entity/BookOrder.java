package com.book.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 书店订单主表(BookOrder)表实体类
 *
 * @author jojo思密达
 * @since 2025-12-05 10:31:54
 */
@SuppressWarnings("serial")
public class BookOrder extends Model<BookOrder> {
    /**
     * 订单编号（主键，规则：时间戳+随机数，如202512041000001234）     
     */
    private Long orderId;
    /**
     * 下单用户ID（关联用户表user_id）     
     */
    private String userId;
    /**
     * 订单状态：0-待付款 1-待发货 2-待收货 3-已完成 4-已取消 5-退款中 6-已退款     
     */
    private Integer orderStatus;
    /**
     * 订单总金额（所有图书金额之和）     
     */
    private BigDecimal totalAmount;
    /**
     * 实际支付金额（扣除优惠券/满减后）     
     */
    private BigDecimal payAmount;
    /**
     * 优惠金额（优惠券+满减等）     
     */
    private BigDecimal discountAmount;
    /**
     * 运费（满额包邮则为0）     
     */
    private BigDecimal freight;
    /**
     * 支付方式：1-微信 2-支付宝 3-线下支付     
     */
    private Integer payType;
    /**
     * 支付时间（未支付则为NULL）     
     */
    private LocalDateTime payTime;
    /**
     * 收货人姓名     
     */
    private String consignee;
    /**
     * 收货人电话     
     */
    private String phone;
    /**
     * 收货地址     
     */
    private String address;
    /**
     * 取消原因（仅状态为4时填写）     
     */
    private String cancelReason;
    /**
     * 订单创建时间     
     */
    private LocalDateTime createTime;
    /**
     * 订单创建人     
     */
    private String creater;
    /**
     * 订单更新时间     
     */
    private LocalDateTime updateTime;
    /**
     * 更新者     
     */
    private String updater;
    /**
     * 是否删除     
     */
    private Integer isDelete;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    
}

