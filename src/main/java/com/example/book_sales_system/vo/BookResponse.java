package com.example.book_sales_system.vo;

import com.example.book_sales_system.entity.Book;

import java.util.List;

public class BookResponse {
    private Book book;
    private String message ;
//    private List<Book> bookList;
    private List<?> ResponseList;
//    private List<CustomerResponse> customerResponsesList;
//    private List<VenderResponse> venderResponsesList;
//=======================================================================================

    public BookResponse() {
    }

    public BookResponse(String message, List<?> responseList) {
        this.message = message;
        ResponseList = responseList;
    }

    public BookResponse(Book book, String message) {
        this.book = book;
        this.message = message;
    }

    public BookResponse(String message) {
        this.message = message;
    }

//=======================================================================================


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<?> getResponseList() {
        return ResponseList;
    }

    public void setResponseList(List<?> responseList) {
        ResponseList = responseList;
    }
}
