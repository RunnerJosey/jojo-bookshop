package com.book.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 购物车表(CartItem)表实体类
 *
 * @author jojo思密达
 * @since 2025-12-02 15:12:05
 */
@SuppressWarnings("serial")
public class CartItem extends Model<CartItem> {
    /**
     * 主键ID     
     */
    private Long id;
    /**
     * 用户ID     
     */
    private Long userId;
    /**
     * 书籍SKU ID     
     */
    private String bookId;
    /**
     * 书籍规格ID     
     */
    private String specId;
    /**
     * 书籍数量     
     */
    private Integer quantity;
    /**
     * 加购时单价     
     */
    private Double price;
    /**
     * 是否选中（1=是，0=否）     
     */
    private Integer selected;
    /**
     * 加购时间     
     */
    private LocalDateTime addTime;
    /**
     * 更新时间     
     */
    private LocalDateTime updateTime;
    /**
     * 是否删除（1=删除，0=正常）     
     */
    private Integer isDeleted;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }

    public LocalDateTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalDateTime addTime) {
        this.addTime = addTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    
}

