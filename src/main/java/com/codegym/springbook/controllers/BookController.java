package com.codegym.springbook.controllers;

import com.codegym.springbook.models.Book;
import com.codegym.springbook.models.Category;
import com.codegym.springbook.service.BookService;
import com.codegym.springbook.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }
    @GetMapping("book-create")
    public ModelAndView showCreateBookForm(){
        return new ModelAndView("create","book",new Book());
    }

    @PostMapping("create")
    public ModelAndView createBook(@Validated @ModelAttribute("book")Book book, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("create");

        if (result.hasFieldErrors()){
            modelAndView.addObject(result.getModel());
            return modelAndView;
        }else {
            bookService.save(book);
            modelAndView.addObject("mess","Book create Success!!");
            return modelAndView;
        }
    }
    @GetMapping("book-list")
    public ModelAndView showListBook(@PageableDefault(size = 3)Pageable pageable){
        Page<Book> books = bookService.findAll(pageable);
        return new ModelAndView("list","books",books);
    }

    @GetMapping("book-edit/{id}")
    public ModelAndView showEditBookForm(@PathVariable Long id){
        Book book = bookService.findById(id);
        return new ModelAndView("edit","book",book);
    }

    @PostMapping("edit")
    public ModelAndView editBook(@Validated @ModelAttribute("book")Book book,BindingResult result){
        ModelAndView modelAndView = new ModelAndView("edit");
        if (result.hasFieldErrors()){
            modelAndView.addObject(result.getModel());
            return modelAndView;
        }else {
            bookService.save(book);
            modelAndView.addObject("message","Book Edit Success!");
            return modelAndView;
        }
    }

    @GetMapping("book-delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Book book = bookService.findById(id);
        return new ModelAndView("delete","book",book);
    }
    @PostMapping("delete")
    public String deleteBook(@ModelAttribute("book")Book book){
        bookService.delete(book.getId());
        return "redirect:book-list";
    }
    @GetMapping("book-search")
    public ModelAndView showSearchBook(@PageableDefault(size = 2)Pageable pageable, @RequestParam("code")String code){
        Page<Book> books = bookService.findAllByCodeContaining(pageable,code);
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("books",books);
        modelAndView.addObject("code",code);
        return modelAndView;
    }
}
