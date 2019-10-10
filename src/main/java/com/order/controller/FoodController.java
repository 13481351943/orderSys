package com.order.controller;

import com.order.entity.Food;
import com.order.service.IFoodService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/food")
@Api(tags = "菜品控制器Api", description = "菜品控制器提供基础增删改查和其他方法")
public class FoodController {

    @Autowired
    private IFoodService foodService;

    @PostMapping("saveFood")
    public Integer saveFood(@RequestBody  Food food){
        return  foodService.saveFood(food);
    }

    @PostMapping("updateFood")
    public Integer updateFood(@RequestBody  Food food){
        return  foodService.updateFood(food);
    }

    @PostMapping("delFood")
    public Integer delFood(Integer foodId){
        return  foodService.delFood(foodId);
    }

    @PostMapping("updateFoodStatusOver")
    public Integer updateFoodStatusOver(Integer foodId){
        return foodService.updateFoodStatusOver(foodId);
    }

    @PostMapping("/listFood")
    public List<Food> listFood(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                               @RequestParam(value = "name",required = false) String name,
                               @RequestParam(value = "sales",required = false) Integer sales){
        return foodService.listFood(categoryId,name,sales);
    }
}
