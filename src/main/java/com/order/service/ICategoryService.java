package com.order.service;

import com.order.entity.Category;

import java.util.List;

public interface ICategoryService{

    List<Category> getAllCategory(String name, Integer type);

    Integer delCate(Integer id);

    Integer updateCate(Category category);

    Integer saveCate(Category category);
    
    Integer updateCategoryStatus(Integer categoryId, Integer state);
}
