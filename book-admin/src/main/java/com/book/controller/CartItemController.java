package com.book.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.entity.CartItem;
import com.book.service.CartItemService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.book.common.CommonResult;
import static com.book.common.CommonResult.success;
import com.book.request.BasePageReq;

/**
 * 购物车表(CartItem)表控制层
 *
 * @author jojo思密达
 * @since 2025-12-02 15:14:53
 */
@RestController
@RequestMapping("cartItem")
public class CartItemController  {
    /**
     * 服务对象
     */
    @Resource
    private CartItemService cartItemService;

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("selectPage")
    public CommonResult selectAll(BasePageReq req) {
        Page<CartItem> page = new Page<>(req.getCurrent(), req.getSize());
        CartItem cartItem= new CartItem ();
        return success(this.cartItemService.page(page, new QueryWrapper<>(cartItem)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getById")
    public CommonResult selectOne(@PathVariable Long id) {
        return success(this.cartItemService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param cartItem 实体对象
     * @return 新增结果
     */
    @PostMapping("add")
    public CommonResult insert(@RequestBody CartItem cartItem) {
        return success(this.cartItemService.save(cartItem));
    }

    /**
     * 修改数据
     *
     * @param cartItem 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public CommonResult update(@RequestBody CartItem cartItem) {
        return success(this.cartItemService.updateById(cartItem));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public CommonResult delete(@RequestParam("idList") List<Long> idList) {
        return success(this.cartItemService.removeByIds(idList));
    }
}

