package com.example.book_sales_system.vo;

public class CategoryResponse {
    private String bookName;
    private String author;
    private int price;
    private int inventory;
//==============================================================================================================

    public CategoryResponse() {
    }

    public CategoryResponse( String bookName, String author, int price, int inventory) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.inventory = inventory;
    }
//==============================================================================================================



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

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
