package com.example.book_sales_system.entity;

public class ShenHeBook {
    private String isbn;
    private String bookName;
    private String author;
    private int price;

    public ShenHeBook() {
    }

    public ShenHeBook(String isbn, String bookName, String author, int price) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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
