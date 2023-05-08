package com.example.book_sales_system.controller;

import com.example.book_sales_system.service.ifs.BookService;
import com.example.book_sales_system.vo.BookRequest;
import com.example.book_sales_system.vo.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private  BookService bookService;
    @PostMapping(value = "add_book")
    public BookResponse addBook(@RequestBody BookRequest request){
        return bookService.addBook(request);
    }
    @PostMapping(value = "search by category")
    public BookResponse searchBookByCategory(@RequestBody BookRequest request){
        return bookService.searchBookByCategory(request);
    }
    @PostMapping(value = "searchBookAccordingBy")
    public BookResponse searchBookAccordingBy(@RequestBody BookRequest request){
        return bookService.searchBookAccordingBy(request);
    }

}
