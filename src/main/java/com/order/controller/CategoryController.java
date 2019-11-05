package com.order.controller;

import com.order.common.util.UserUtils;
import com.order.entity.Category;
import com.order.service.ICategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/category")
@Api(tags = "品类控制器Api", description = "品类控制器提供基础增删改查和其他方法")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private UserUtils userUtils;
    
    @PostMapping("saveCate")
    public Integer saveCate(@RequestBody  Category category){
    	category.setCreateBy(userUtils.getSysUser().getName());
        return categoryService.saveCate(category);
    }

    @PostMapping("updateCategoryStatus")
    public Integer updateCategoryStatus(Integer categoryId,Integer state) {
    	return categoryService.updateCategoryStatus(categoryId,state);
    }
    
    @PostMapping("updateCate")
    public Integer updateCate(@RequestBody  Category category){
        return categoryService.updateCate(category);
    }

    @PostMapping("delCate")
    public Integer delCate(Integer categoryId){
        return categoryService.delCate(categoryId);
    }

    @PostMapping("getAllCategory")
    public List<Category> getAllCategory(@RequestParam(value = "name",required = false) String name,
                                         @RequestParam(value = "type",required = false) Integer type){
        return categoryService.getAllCategory(name,type);
    }

}
