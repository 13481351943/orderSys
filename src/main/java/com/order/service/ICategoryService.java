package com.order.service;

import com.order.core.support.IBaseService;
import com.order.entity.Category;

import java.util.List;

public interface ICategoryService extends IBaseService<Category> {

    List<Category> getAllCategory(String name, Integer type);

    Integer delCate(String id);

    Integer updateCate(Category category);

    Integer saveCate(Category category);
}
