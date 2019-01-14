package com.codegym.springbook.service;

import com.codegym.springbook.models.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(Long id);
}
