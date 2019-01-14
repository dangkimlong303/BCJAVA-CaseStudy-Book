package com.codegym.springbook.repository;

import com.codegym.springbook.models.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category,Long> {

}
