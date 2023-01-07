package com.ironhack.ShoppingCart.controller;

import com.ironhack.ShoppingCart.model.Category;
import com.ironhack.ShoppingCart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return "successfully created";
    }

    @GetMapping("/list")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategory();
    }
}
