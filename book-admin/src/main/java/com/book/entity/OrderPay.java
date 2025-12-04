package com.book.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 书店订单支付记录表(OrderPay)表实体类
 *
 * @author jojo思密达
 * @since 2025-12-04 16:46:42
 */
@SuppressWarnings("serial")
public class OrderPay extends Model<OrderPay> {
    /**
     * 支付记录ID（主键）     
     */
    private Long payId;
    /**
     * 关联订单ID     
     */
    private String orderId;
    /**
     * 第三方支付流水号（微信/支付宝返回）     
     */
    private String payNo;
    /**
     * 支付状态：0-支付中 1-支付成功 2-支付失败     
     */
    private Integer payStatus;
    /**
     * 支付金额     
     */
    private BigDecimal payAmount;
    /**
     * 支付完成时间     
     */
    private LocalDateTime payTime;
    /**
     * 退款金额（未退款则为0）     
     */
    private BigDecimal refundAmount;
    /**
     * 退款时间     
     */
    private LocalDateTime refundTime;
    /**
     * 支付记录创建时间     
     */
    private LocalDateTime createTime;
    /**
     * 创建者     
     */
    private String creater;
    /**
     * 支付记录更新时间     
     */
    private LocalDateTime updateTime;
    /**
     * 更新者     
     */
    private String updater;
    /**
     * 是否删除     
     */
    private String isDelete;


    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
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

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public LocalDateTime getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(LocalDateTime refundTime) {
        this.refundTime = refundTime;
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

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    
}

