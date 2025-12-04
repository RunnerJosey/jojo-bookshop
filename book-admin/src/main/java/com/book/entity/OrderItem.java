package com.book.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 书店订单明细表(OrderItem)表实体类
 *
 * @author jojo思密达
 * @since 2025-12-04 16:46:42
 */
@SuppressWarnings("serial")
public class OrderItem extends Model<OrderItem> {
    /**
     * 明细ID（主键）     
     */
    private Long itemId;
    /**
     * 关联订单主表ID     
     */
    private String orderId;
    /**
     * 图书ISBN编码（关联图书表isbn）     
     */
    private String isbn;
    /**
     * 图书名称（冗余存储，避免图书表修改后订单名称变化）     
     */
    private String bookName;
    /**
     * 图书单价（下单时的价格，冗余存储）     
     */
    private BigDecimal bookPrice;
    /**
     * 购买数量     
     */
    private Integer quantity;
    /**
     * 该图书小计金额（book_price * quantity）     
     */
    private BigDecimal subtotal;
    /**
     * 该图书单独优惠金额（如单本折扣）     
     */
    private BigDecimal discount;
    /**
     * 明细创建时间     
     */
    private LocalDateTime createTime;
    /**
     * 创建人     
     */
    private String creater;
    /**
     * 更新时间     
     */
    private LocalDateTime updateTime;
    /**
     * 更新人     
     */
    private String updater;
    /**
     * 是否删除     
     */
    private Integer isDelete;


    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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

