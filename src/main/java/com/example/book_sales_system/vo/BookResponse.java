package com.example.book_sales_system.vo;

import com.example.book_sales_system.entity.Book;

import java.util.List;

public class BookResponse {
    private Book book;
    private String message ;
//    private List<Book> bookList;
    private List<CategoryResponse> categoryResponseList;
    private List<CustomerResponse> customerResponsesList;
    private List<VenderResponse> venderResponsesList;
//=======================================================================================

    public BookResponse() {
    }

//    public BookResponse(String message, List<VenderResponse> venderResponsesList) {
//        this.message = message;
//        this.venderResponsesList = venderResponsesList;
//    }
    //    public BookResponse(String message, List<CustomerResponse> customerResponsesList) {
//        this.message = message;
//        this.customerResponsesList = customerResponsesList;
//    }
//
    public BookResponse(String message, List<CategoryResponse> categoryResponseList) {
        this.message = message;
        this.categoryResponseList = categoryResponseList;
    }

    public BookResponse(Book book, String message) {
        this.book = book;
        this.message = message;
    }

    public BookResponse(String message) {
        this.message = message;
    }

//=======================================================================================

    public List<CategoryResponse> getCategoryResponseList() {
        return categoryResponseList;
    }

    public void setCategoryResponseList(List<CategoryResponse> categoryResponseList) {
        this.categoryResponseList = categoryResponseList;
    }

    public List<VenderResponse> getVenderResponsesList() {
        return venderResponsesList;
    }

    public void setVenderResponsesList(List<VenderResponse> venderResponsesList) {
        this.venderResponsesList = venderResponsesList;
    }

    public List<CustomerResponse> getCustomerResponsesList() {
        return customerResponsesList;
    }

    public void setCustomerResponsesList(List<CustomerResponse> customerResponsesList) {
        this.customerResponsesList = customerResponsesList;
    }

//    public List<Book> getBookList() {
//        return bookList;
//    }
//
//    public void setBookList(List<Book> bookList) {
//        this.bookList = bookList;
//    }
//
//    public List<CategoryResponse> getCategoryResponseList() {
//        return categoryResponseList;
//    }
//
//    public void setCategoryResponseList(List<CategoryResponse> categoryResponseList) {
//        this.categoryResponseList = categoryResponseList;
//    }

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
}
