package com.book.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.io.Serializable;
import lombok.Data;

/**
 * 书店用户收货地址表(UserAddress)表实体类
 *
 * @author bookshop-easycode-template-mybatisplus
 * @since 2025-12-17 10:09:24
 */
@SuppressWarnings("serial")
@Data
@TableName("user_address")
public class UserAddress extends Model<UserAddress> {

    /**
     * 地址ID（主键，规则：时间戳+随机数）
     */     
     @TableId(type = IdType.AUTO)
     private Long addressId;
     
    /**
     * 关联用户ID（外键，关联用户表）     
     */
    private Long userId;
    /**
     * 收货人姓名     
     */
    private String consigneeName;
    /**
     * 收货人手机号（需做脱敏存储，如138****1234）     
     */
    private String consigneePhone;
    /**
     * 省份名称（冗余存储，如广东省）     
     */
    private String provinceName;
    /**
     * 城市名称（如广州市）     
     */
    private String cityName;
    /**
     * 区县名称（如天河区）     
     */
    private String districtName;
    /**
     * 详细地址（如XX街道XX小区XX栋XX单元）     
     */
    private String detailAddress;
    /**
     * 地址标签（如家庭、公司、学校）     
     */
    private String addressLabel;
    /**
     * 是否默认地址：0-否 1-是（一个用户仅能有一个默认地址）     
     */
    private Integer isDefault;
    /**
     * 创建时间     
     */
    private LocalDateTime createTime;
    /**
     * 更新时间     
     */
    private LocalDateTime updateTime;
    /**
     * 逻辑删除：0-未删除 1-已删除     
     */
    private Integer isDeleted;


    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getAddressLabel() {
        return addressLabel;
    }

    public void setAddressLabel(String addressLabel) {
        this.addressLabel = addressLabel;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
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

