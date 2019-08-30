package com.order.service.impl;

import com.order.entity.Category;
import com.order.entity.CategoryCriteria;
import com.order.mapper.CategoryMapper;
import com.order.service.ICategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Integer saveCate(Category category){
        return categoryMapper.insertSelective(category);
    }

    @Override
    public Integer updateCate(Category category){
        return categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public Integer delCate(String id){
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Category> getAllCategory(String name,Integer type){
        CategoryCriteria categoryCriteria = new CategoryCriteria();
        if(StringUtils.isNoneBlank(name)){
            categoryCriteria.createCriteria().andNameLike(name);
        }
        if(type != null){
            categoryCriteria.createCriteria().andTypeEqualTo(type);
        }
        categoryCriteria.setOrderByClause("sort");
        return categoryMapper.selectByExample(categoryCriteria);
    }



}
