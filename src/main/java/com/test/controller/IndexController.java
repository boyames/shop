package com.test.controller;


import com.test.pojo.Category;
import com.test.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
     private ICategoryService categoryService;

    public ICategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/index")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        //查询类别 传到index
        List<Category> categoryList=categoryService.selectCategoryList();

        modelAndView.addObject("categoryList",categoryList);

        return modelAndView;
    }
}
