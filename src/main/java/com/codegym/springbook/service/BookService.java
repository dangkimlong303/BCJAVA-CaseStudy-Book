package com.codegym.springbook.service;

import com.codegym.springbook.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Book findById(Long id);

    void save(Book book);

    void delete(Long id);

    Page<Book> findAllByCodeContaining(Pageable pageable,String code);

}
