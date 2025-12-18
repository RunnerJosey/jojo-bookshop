package com.book.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.io.Serializable;
import lombok.Data;

/**
 * 书店订单主表(BookOrder)表实体类
 *
 * @author bookshop-easycode-template-mybatisplus
 * @since 2025-12-17 11:08:51
 */
@SuppressWarnings("serial")
@Data
@TableName("book_order")
public class BookOrder extends Model<BookOrder> {

    /**
     * 订单编号（主键，规则：时间戳+随机数，如202512041000001234）
     */     
     @TableId(type = IdType.AUTO)
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
     * 关联的购物车id     
     */
    private Long cartItemId;
    /**
     * 优惠金额（优惠券+满减等）     
     */
    private BigDecimal discountAmount;
    /**
     * 运费（满额包邮则为0）     
     */
    private BigDecimal freight;
    /**
     * 订单总金额（所有图书金额之和）     
     */
    private BigDecimal totalAmount;
    /**
     * 支付方式：1-微信 2-支付宝 3-线下支付     
     */
    private Integer payType;
    /**
     * 实际支付金额（扣除优惠券/满减后）     
     */
    private BigDecimal payAmount;
    /**
     * 支付时间（未支付则为NULL）     
     */
    private LocalDateTime payTime;
    /**
     * 收货地址id     
     */
    private Long addressId;
    /**
     * 收货人姓名     
     */
    private String consigneeName;
    /**
     * 收货人电话     
     */
    private String consigneePhone;
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

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
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

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public LocalDateTime getPayTime() {
        return payTime;
    }

    public void setPayTime(LocalDateTime payTime) {
        this.payTime = payTime;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
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

