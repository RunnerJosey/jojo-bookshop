package com.book.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.basepage.CommonResult;
import com.book.entity.OmsOrder;
import com.book.service.OmsOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 订单表(OmsOrder)表控制层
 *
 * @author makejava
 * @since 2024-07-25 14:56:52
 */
@RestController
@RequestMapping("omsOrder")
public class OmsOrderController {
    /**
     * 服务对象
     */
    @Resource
    private OmsOrderService omsOrderService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param omsOrder 查询实体
     * @return 所有数据
     */
    @GetMapping
    public CommonResult selectAll(Page<OmsOrder> page, OmsOrder omsOrder) {
        return CommonResult.success(this.omsOrderService.page(page, new QueryWrapper<>(omsOrder)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult selectOne(@PathVariable Serializable id) {
        return CommonResult.success(this.omsOrderService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param omsOrder 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult insert(@RequestBody OmsOrder omsOrder) {
        return CommonResult.success(this.omsOrderService.save(omsOrder));
    }

    /**
     * 修改数据
     *
     * @param omsOrder 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult update(@RequestBody OmsOrder omsOrder) {
        return CommonResult.success(this.omsOrderService.updateById(omsOrder));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public CommonResult delete(@RequestParam("idList") List<Long> idList) {
        return CommonResult.success(this.omsOrderService.removeByIds(idList));
    }

    /**
     * 新增数据
     *
     * @param omsOrder 实体对象
     * @return 新增结果
     */
    @PostMapping("/getByid")
    public CommonResult getByid(@RequestBody OmsOrder omsOrder) {
        return CommonResult.success(this.omsOrderService.getById(omsOrder.getId()));
    }
}

