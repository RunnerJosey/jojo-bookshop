package com.book.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.entity.OrderItem;
import com.book.service.OrderItemService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.book.common.CommonResult;
import static com.book.common.CommonResult.success;
import com.book.request.BasePageReq;

/**
 * 书店订单明细表(OrderItem)表控制层
 *
 * @author jojo思密达
 * @since 2025-12-04 16:46:42
 */
@RestController
@RequestMapping("orderItem")
public class OrderItemController  {
    /**
     * 服务对象
     */
    @Resource
    private OrderItemService orderItemService;

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("selectPage")
    public CommonResult selectAll(BasePageReq req) {
        Page<OrderItem> page = new Page<>(req.getCurrent(), req.getSize());
        OrderItem orderItem= new OrderItem ();
        return success(this.orderItemService.page(page, new QueryWrapper<>(orderItem)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getById")
    public CommonResult selectOne(@PathVariable Long id) {
        return success(this.orderItemService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param orderItem 实体对象
     * @return 新增结果
     */
    @PostMapping("add")
    public CommonResult insert(@RequestBody OrderItem orderItem) {
        return success(this.orderItemService.save(orderItem));
    }

    /**
     * 修改数据
     *
     * @param orderItem 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public CommonResult update(@RequestBody OrderItem orderItem) {
        return success(this.orderItemService.updateById(orderItem));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public CommonResult delete(@RequestParam("idList") List<Long> idList) {
        return success(this.orderItemService.removeByIds(idList));
    }
}

