package com.book.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.entity.Meal;
import com.book.service.MealService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import com.book.common.CommonResult;
import static com.book.common.CommonResult.success;

/**
 * 菜单表(Menu)表控制层
 *
 * @author jojo思密达
 * @since 2025-09-18 15:33:25
 */
@RestController
@RequestMapping("meal")
public class MealController {
    /**
     * 服务对象
     */
    @Resource
    private MealService mealService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param meal 查询实体
     * @return 所有数据
     */
    @GetMapping
    public CommonResult selectAll(Page<Meal> page, Meal meal) {
        return success(this.mealService.page(page, new QueryWrapper<>(meal)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public CommonResult selectOne(@PathVariable Serializable id) {
        return success(this.mealService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param meal 实体对象
     * @return 新增结果
     */
    @PostMapping
    public CommonResult insert(@RequestBody Meal meal) {
        return success(this.mealService.save(meal));
    }

    /**
     * 修改数据
     *
     * @param meal 实体对象
     * @return 修改结果
     */
    @PutMapping
    public CommonResult update(@RequestBody Meal meal) {
        return success(this.mealService.updateById(meal));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public CommonResult delete(@RequestParam("idList") List<Long> idList) {
        return success(this.mealService.removeByIds(idList));
    }

    /**
     * 选餐按钮
     */
    @PostMapping("/choseMeal")
    public CommonResult choseMeal(@RequestBody Meal meal) {

        return success(this.mealService.choseDishes(meal));
    }

}

