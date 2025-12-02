package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.CartItemDao;
import com.book.entity.CartItem;
import com.book.service.CartItemService;
import org.springframework.stereotype.Service;

/**
 * 购物车表(CartItem)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-12-02 15:12:05
 */
@Service("cartItemService")
public class CartItemServiceImpl extends ServiceImpl<CartItemDao, CartItem> implements CartItemService {

}

