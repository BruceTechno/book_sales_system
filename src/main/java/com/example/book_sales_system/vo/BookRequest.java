package com.example.book_sales_system.vo;

public class BookRequest {

    private String isbn;
    private String bookName;
    private String author;
    private int price;
    private int inventory;
    private int salesFigures;
    private String category;
    private String identity;
    private String keyword;
//================================================================================================

    public BookRequest() {
    }
//================================================================================================


    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getSalesFigures() {
        return salesFigures;
    }

    public void setSalesFigures(int salesFigures) {
        this.salesFigures = salesFigures;
    }
}
