package com.book.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.entity.BookOrder;
import com.book.service.BookOrderService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.book.common.CommonResult;
import static com.book.common.CommonResult.success;
import com.book.request.BasePageReq;

/**
 * 书店订单主表(BookOrder)表控制层
 *
 * @author jojo思密达
 * @since 2025-12-05 10:31:54
 */
@RestController
@RequestMapping("bookOrder")
public class BookOrderController  {
    /**
     * 服务对象
     */
    @Resource
    private BookOrderService bookOrderService;

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping("selectPage")
    public CommonResult selectAll(BasePageReq req) {
        Page<BookOrder> page = new Page<>(req.getCurrent(), req.getSize());
        BookOrder bookOrder= new BookOrder ();
        return success(this.bookOrderService.page(page, new QueryWrapper<>(bookOrder)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("getById")
    public CommonResult selectOne(@PathVariable Long id) {
        return success(this.bookOrderService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param bookOrder 实体对象
     * @return 新增结果
     */
    @PostMapping("add")
    public CommonResult insert(@RequestBody BookOrder bookOrder) {
        return success(this.bookOrderService.save(bookOrder));
    }

    /**
     * 修改数据
     *
     * @param bookOrder 实体对象
     * @return 修改结果
     */
    @PutMapping("update")
    public CommonResult update(@RequestBody BookOrder bookOrder) {
        return success(this.bookOrderService.updateById(bookOrder));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping("delete")
    public CommonResult delete(@RequestParam("idList") List<Long> idList) {
        return success(this.bookOrderService.removeByIds(idList));
    }
}

