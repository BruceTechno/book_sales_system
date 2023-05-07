package com.example.book_sales_system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "ISBN")
    private String isbn ;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    private int price;
    @Column(name = "inventory")
    private int inventory;
    @Column(name = "sales_figures")
    private int salesFigures;
    @Column(name = "category")
    private String category ;
//============================================================================================================

    public Book() {
    }

    public Book(String isbn, String bookName, String author, int price, int inventory, int salesFigures, String category) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.inventory = inventory;
        this.salesFigures = salesFigures;
        this.category = category;
    }

    public Book(String isbn, String bookName, String author, int price, int inventory) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.inventory = inventory;
    }
//============================================================================================================

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
