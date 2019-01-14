package com.codegym.springbook.service.impl;

import com.codegym.springbook.models.Book;
import com.codegym.springbook.repository.BookRepository;
import com.codegym.springbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findAllByCodeContaining(Pageable pageable, String code) {
        return bookRepository.findAllByCodeContaining(pageable,code);
    }
}
