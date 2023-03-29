package com.examportal.backend.service;

import com.examportal.backend.exceptions.CategoryNotFoundException;
import com.examportal.backend.models.Category;

import java.util.Set;

public interface CategoryService {
    Category addCategory(Category category);
    Category updateCategory(Category category);
    Set<Category> getCategories();
    Category getCategory(Long categoryId) throws CategoryNotFoundException;
    void deleteCategory(Long categoryId);
}
