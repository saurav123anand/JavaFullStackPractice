package com.examportal.backend.service.impl;

import com.examportal.backend.exceptions.CategoryNotFoundException;
import com.examportal.backend.models.Category;
import com.examportal.backend.repository.CategoryRepository;
import com.examportal.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) throws CategoryNotFoundException {
        Optional<Category> category= categoryRepository.findById(categoryId);
        if(!category.isPresent()){
            throw new CategoryNotFoundException("Category not found for id "+categoryId);
        }
        return category.get();
    }

    @Override
    public void deleteCategory(Long categoryId) {
       categoryRepository.deleteById(categoryId);
    }
}
