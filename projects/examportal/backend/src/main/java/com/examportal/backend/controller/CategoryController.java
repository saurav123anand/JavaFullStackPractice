package com.examportal.backend.controller;

import com.examportal.backend.exceptions.CategoryNotFoundException;
import com.examportal.backend.models.Category;
import com.examportal.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //add category
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public Category addCategory(@RequestBody Category category){
         return categoryService.addCategory(category);
    }

    //get category
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) throws Exception {
        return this.categoryService.getCategory(categoryId);
    }

    // get all categories
    @GetMapping("/")
    public Set<Category> getCategories(){
        return this.categoryService.getCategories();
    }

    //update category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    //delete category
    @DeleteMapping("/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) throws Exception {
       categoryService.deleteCategory(categoryId);
       return "Category deleted for id "+categoryId;
    }


}
