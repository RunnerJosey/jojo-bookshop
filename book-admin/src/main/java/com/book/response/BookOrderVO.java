package com.book.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 书店订单主表(BookOrder)表实体类
 *
 * @author bookshop-easycode-template-mybatisplus
 * @since 2025-12-17 11:08:51
 */
@Data
public class BookOrderVO extends Model<BookOrderVO> {

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


    
}

