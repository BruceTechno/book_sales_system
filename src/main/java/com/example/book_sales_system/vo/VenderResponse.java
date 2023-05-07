package com.example.book_sales_system.vo;

public class VenderResponse {
    //    顯示書名、ISBN、作者、價格、銷售量、庫存量
    private String isbn;
    private String bookName;
    private String author;
    private int price;
    private int inventory;
    private int salesFigures;
//======================================================================================================

    public VenderResponse() {
    }

    public VenderResponse(String isbn, String bookName, String author, int price, int inventory, int salesFigures) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.inventory = inventory;
        this.salesFigures = salesFigures;
    }
//======================================================================================================

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
