package com.order.service.impl;

import com.order.entity.Food;
import com.order.entity.FoodCriteria;
import com.order.mapper.FoodMapper;
import com.order.service.IFoodService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements IFoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public Integer saveFood(Food food){
        return foodMapper.insertSelective(food);
    }

    @Override
    public Integer updateFood(Food food){
        return foodMapper.updateByPrimaryKeySelective(food);
    }

    @Override
    public Integer delFood(Integer foodId){
        return foodMapper.deleteByPrimaryKey(foodId);
    }

    /**
     * 功能描述: 手动售罄
     * @author: huangbin
     * @param: [foodId , state] 
     * @Return: java.lang.Integer
     * @Date: 2019/8/30 15:11
     */
    @Override
    public Integer updateFoodStatusOver(Integer foodId ,Integer state){
        Food food = new Food();
        food.setId(foodId);
        food.setStatus(state);
        return foodMapper.updateByPrimaryKeySelective(food);
    }

    @Override
    public List<Food> listFood(Integer categoryId,String name,Integer sales){
        FoodCriteria criteria = new FoodCriteria();
        if(categoryId != null){
            criteria.createCriteria().andCategoryIdEqualTo(categoryId);
        }
        if(StringUtils.isNotBlank(name)){
            criteria.createCriteria().andNameLike(name);
        }
        if(sales != null){
            criteria.createCriteria().andSalesEqualTo(sales);
        }
        criteria.setOrderByClause("sort");
        return foodMapper.selectByExample(criteria);
    }








}
