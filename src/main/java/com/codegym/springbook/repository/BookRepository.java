package com.codegym.springbook.repository;

import com.codegym.springbook.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book,Long> {
    Page<Book> findAllByCodeContaining(Pageable pageable,String code);
}
