package com.book.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.MealDao;
import com.book.entity.Meal;
import com.book.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 菜单表(Menu)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-09-18 15:33:25
 */
@Service("menuService")
public class MenuServiceImpl extends ServiceImpl<MealDao, Meal> implements MealService {

    @Autowired
    MealDao mealDao;

    @Override
    public Meal choseDishes(Meal meal) {
        LambdaQueryWrapper<Meal> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(Meal::getCreater,"josey");
        List<Meal> meals = mealDao.selectList(queryWrapper);
        //根据用户查询菜单
        //先给所有的菜单编号

        //获取一个随机数

//        // 模拟菜单列表
//        List<String> meals = new ArrayList<>();
//        meals.add("宫保鸡丁");
//        meals.add("牛肉汉堡");
//        meals.add("寿司拼盘");
//        meals.add("麻辣烫");
        // 从列表中随机选择一个元素
        Meal randomMeal = selectRandom(meals);
        System.out.println("随机选择的菜品：" + randomMeal.getDishesName());

        return randomMeal;
    }

    /**
     * 从列表中随机选择一个元素的方法
     */
    public static <T> T selectRandom(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("列表不能为空");
        }
        // 生成 0 到 list.size()-1 之间的随机索引
        int randomIndex = ThreadLocalRandom.current().nextInt(list.size());
        // 通过索引获取元素
        return list.get(randomIndex);
    }
}

