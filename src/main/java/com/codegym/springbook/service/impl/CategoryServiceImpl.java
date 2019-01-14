package com.codegym.springbook.service.impl;

import com.codegym.springbook.models.Category;
import com.codegym.springbook.repository.CategoryRepository;
import com.codegym.springbook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
