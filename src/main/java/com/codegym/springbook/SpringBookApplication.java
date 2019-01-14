package com.codegym.springbook;

import com.codegym.springbook.service.BookService;
import com.codegym.springbook.service.CategoryService;
import com.codegym.springbook.service.impl.BookServiceImpl;
import com.codegym.springbook.service.impl.CategoryServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBookApplication.class, args);
	}

	@Bean
	public BookService bookService(){
		return new BookServiceImpl();
	}
	@Bean
	public CategoryService categoryService(){
		return new CategoryServiceImpl();
	}
}

