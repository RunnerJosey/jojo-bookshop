package com.book.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.entity.BookOrder;
import com.book.entity.BookOrderItem;
import com.book.enums.BusinessErrorCodeEnum;
import com.book.exception.BusinessException;
import com.book.request.BasePageReq;
import com.book.request.BookOrderCreateRequest;
import com.book.response.BookOrderResponse;
import com.book.service.BookOrderItemService;
import com.book.service.BookOrderService;
import com.book.utils.HttpRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import com.book.common.CommonResult;
import static com.book.common.CommonResult.success;

/**
 * 书店订单主表(BookOrder)表控制层
 *
 * @author jojo思密达
 * @since 2025-12-05 10:31:54
 */
@RestController
@RequestMapping("bookOrder")
public class BookOrderController {
    /**
     * 服务对象
     */
    @Resource
    private BookOrderService bookOrderService;

    @Resource
    private BookOrderItemService bookOrderItemService;

    @Autowired
    private HttpRequestUtil httpRequestUtil;

    /**
     * 分页查询当前用户的订单（可按状态筛选）
     *
     * @return 订单分页数据
     */
    @GetMapping("selectPage")
    public CommonResult selectAll(BasePageReq req,
                                  @RequestParam(value = "orderStatus", required = false) Integer orderStatus) {
        Long userId = httpRequestUtil.getCurrentUserInfo().getId();
        Page<BookOrder> page = new Page<>(req.getCurrent(), req.getSize());
        QueryWrapper<BookOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", String.valueOf(userId));
        if (orderStatus != null) {
            wrapper.eq("order_status", orderStatus);
        }
        wrapper.orderByDesc("create_time");
        return success(this.bookOrderService.page(page, wrapper));
    }

    /**
     * 通过主键查询订单详情（含明细）
     *
     * @param id 主键
     * @return 订单详情
     */
    @GetMapping("getById")
    public CommonResult getById(@RequestParam("id") Long id) {
        BookOrder order = this.bookOrderService.getById(id);
        if (order == null) {
            throw new BusinessException(BusinessErrorCodeEnum.ORDER_NOT_FOUND);
        }
        BookOrderResponse response = new BookOrderResponse();
        response.setOrder(order);
        List<BookOrderItem> items = this.bookOrderItemService.list(
                new QueryWrapper<BookOrderItem>().eq("order_id", String.valueOf(id)));
        response.setItemList(items);
        return success(response);
    }

    /**
     * 下单：由购物车生成订单
     *
     * @param request 下单请求
     * @return 生成的订单
     */
    @PostMapping("checkout")
    public CommonResult checkout(@RequestBody BookOrderCreateRequest request) {
        Long userId = httpRequestUtil.getCurrentUserInfo().getId();
        return success(this.bookOrderService.checkout(userId, request));
    }

    /**
     * 修改订单（如取消订单、修改状态）
     *
     * @param bookOrder 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public CommonResult update(@RequestBody BookOrder bookOrder) {
        return success(this.bookOrderService.updateById(bookOrder));
    }

    /**
     * 删除订单（同时删除对应明细）
     *
     * @param idList 主键集合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public CommonResult delete(@RequestParam("idList") List<Long> idList) {
        if (idList != null && !idList.isEmpty()) {
            bookOrderItemService.remove(new QueryWrapper<BookOrderItem>()
                    .in("order_id", idList.stream().map(String::valueOf).collect(Collectors.toList())));
        }
        return success(this.bookOrderService.removeByIds(idList));
    }
}
