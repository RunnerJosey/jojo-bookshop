package com.book.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.book.entity.Meal;

/**
 * 菜单表(Menu)表服务接口
 *
 * @author jojo思密达
 * @since 2025-09-18 15:33:25
 */
public interface MealService extends IService<Meal> {

    Meal choseDishes(Meal meal);
}

