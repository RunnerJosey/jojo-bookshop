package com.book.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * 书店用户收货地址表(BookUserAddress)表实体类
 *
 * @author jojo思密达
 * @since 2025-12-08 17:46:05
 */
@SuppressWarnings("serial")
public class BookUserAddress extends Model<BookUserAddress> {
    /**
     * 地址ID（主键，规则：时间戳+随机数）     
     */
    private String addressId;
    /**
     * 关联用户ID（外键，关联用户表）     
     */
    private String userId;
    /**
     * 收货人姓名     
     */
    private String consignee;
    /**
     * 收货人手机号（需做脱敏存储，如138****1234）     
     */
    private String phone;
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


    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

