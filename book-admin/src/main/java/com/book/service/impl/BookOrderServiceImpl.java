package com.book.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.BookOrderDao;
import com.book.entity.BookOrder;
import com.book.entity.BookOrderItem;
import com.book.entity.UserAddress;
import com.book.entity.CartItem;
import com.book.enums.BusinessErrorCodeEnum;
import com.book.exception.BusinessException;
import com.book.request.BookOrderCreateRequest;
import com.book.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 书店订单主表(BookOrder)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-12-05 10:31:54
 */
@Service("bookOrderService")
public class BookOrderServiceImpl extends ServiceImpl<BookOrderDao, BookOrder> implements BookOrderService {

    @Resource
    private CartItemService cartItemService;

    @Resource
    private BookOrderItemService bookOrderItemService;

    @Resource
    private UserAddressService bookUserAddressService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BookOrder checkout(Long userId, BookOrderCreateRequest request) {
        if (request == null || CollectionUtil.isEmpty(request.getCartItemIds())) {
            throw new BusinessException(BusinessErrorCodeEnum.VALIDATE_FAILED.getCode(), "请选择要结算的商品");
        }
        if (request.getAddressId() == null) {
            throw new BusinessException(BusinessErrorCodeEnum.VALIDATE_FAILED.getCode(), "请选择收货地址");
        }

        // 1. 查询购物车项，确保属于当前用户
        List<CartItem> cartItems = cartItemService.list(new QueryWrapper<CartItem>()
                .in("id", request.getCartItemIds())
                .eq("user_id", userId));
        if (CollectionUtil.isEmpty(cartItems)) {
            throw new BusinessException(BusinessErrorCodeEnum.VALIDATE_FAILED.getCode(), "购物车商品不存在");
        }

        // 2. 查询并校验收货地址归属
        UserAddress address = bookUserAddressService.getById(request.getAddressId());
        if (address == null || !userId.equals(address.getUserId())) {
            throw new BusinessException(BusinessErrorCodeEnum.VALIDATE_FAILED.getCode(), "收货地址不存在");
        }

        // 3. 计算订单总金额
        BigDecimal totalAmount = cartItems.stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 4. 组装并保存订单主表
        LocalDateTime now = LocalDateTime.now();
        BookOrder order = new BookOrder();
        order.setUserId(String.valueOf(userId));
        order.setOrderStatus(0);
        order.setTotalAmount(totalAmount);
        order.setDiscountAmount(BigDecimal.ZERO);
        order.setFreight(BigDecimal.ZERO);
        order.setPayAmount(totalAmount);
        order.setPayType(request.getPayType() == null ? 1 : request.getPayType());
        order.setAddressId(address.getAddressId());
        order.setConsignee(address.getConsignee());
        order.setPhone(address.getPhone());
        order.setAddress(buildFullAddress(address));
        order.setCreateTime(now);
        order.setUpdateTime(now);
        order.setIsDelete(0);
        this.save(order);

        // 5. 生成订单明细
        List<BookOrderItem> orderItems = cartItems.stream().map(cartItem -> {
            BookOrderItem item = new BookOrderItem();
            item.setOrderId(String.valueOf(order.getOrderId()));
            item.setIsbn(cartItem.getBookId());
            item.setBookName(cartItem.getBookName());
            item.setBookPrice(cartItem.getPrice());
            item.setQuantity(cartItem.getQuantity());
            item.setSubtotal(cartItem.getPrice().multiply(BigDecimal.valueOf(cartItem.getQuantity())));
            item.setDiscount(BigDecimal.ZERO);
            item.setCreateTime(now);
            item.setUpdateTime(now);
            item.setIsDelete(0);
            return item;
        }).collect(Collectors.toList());
        bookOrderItemService.saveBatch(orderItems);

        // 6. 清空已下单的购物车项
        cartItemService.removeByIds(request.getCartItemIds());

        return order;
    }

    /**
     * 拼接完整收货地址（省 + 市 + 区县 + 详细地址）
     */
    private String buildFullAddress(UserAddress address) {
        StringBuilder sb = new StringBuilder();
        if (address.getProvinceName() != null) {
            sb.append(address.getProvinceName());
        }
        if (address.getCityName() != null) {
            sb.append(address.getCityName());
        }
        if (address.getDistrictName() != null) {
            sb.append(address.getDistrictName());
        }
        if (address.getDetailAddress() != null) {
            sb.append(address.getDetailAddress());
        }
        return sb.toString();
    }
}
