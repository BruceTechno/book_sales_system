package com.example.book_sales_system.service.ifs;

import com.example.book_sales_system.vo.BookRequest;
import com.example.book_sales_system.vo.BookResponse;

import java.util.List;


public interface BookService {
    public BookResponse addBook(BookRequest request);
    public BookResponse searchBookByCategory (BookRequest request);
    public BookResponse searchBookAccordingBy (BookRequest request);
    //用一個String pattern "消費者" 一個"書籍商" 讓使用者從postman輸入 去比對 哪一個為true 則顯示那一個
    public BookResponse updateBookInfo (BookRequest request);
}
