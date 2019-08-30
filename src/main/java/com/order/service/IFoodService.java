package com.order.service;

import com.order.core.support.IBaseService;
import com.order.entity.Food;

import java.util.List;

public interface IFoodService extends IBaseService<Food> {

    Integer saveFood(Food food);

    Integer updateFood(Food food);

    Integer delFood(Integer foodId);

    Integer updateFoodStatusOver(Integer foodId);

    List<Food> listFood(Integer categoryId, String name, Integer sales);

}
