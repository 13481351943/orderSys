package com.order.service;

import com.order.entity.Category;

import java.util.List;

public interface ICategoryService{

    List<Category> getAllCategory(String name, Integer type);

    Integer delCate(String id);

    Integer updateCate(Category category);

    Integer saveCate(Category category);
}
