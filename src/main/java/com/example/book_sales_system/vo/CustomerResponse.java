package com.example.book_sales_system.vo;

public class CustomerResponse {
//    書名、ISBN、作者、價格
    private String bookName;
    private String isbn ;
    private String author;
    private int price;
//====================================================================================

    public CustomerResponse() {
    }

    public CustomerResponse(String bookName, String isbn, String author, int price) {
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
    }

//====================================================================================

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
