package com.test.service.impl;


import com.test.mapper.CategoryMapper;
import com.test.pojo.Category;
import com.test.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryMapper getCategoryMapper() {
        return categoryMapper;
    }

    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    //查询所有的类别
    @Override
    public List<Category> selectCategoryList() {
        return categoryMapper.selectCategoryList();
    }
}
