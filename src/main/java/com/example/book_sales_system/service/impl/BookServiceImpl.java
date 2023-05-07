package com.example.book_sales_system.service.impl;

import com.example.book_sales_system.constants.RtnCode;
import com.example.book_sales_system.entity.Book;
import com.example.book_sales_system.repository.BookDao;
import com.example.book_sales_system.service.ifs.BookService;
import com.example.book_sales_system.vo.BookRequest;
import com.example.book_sales_system.vo.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public BookResponse addBook(BookRequest request) {
        String isbn = request.getIsbn();
        String bookName = request.getBookName();
        String author = request.getAuthor();
        int price = request.getPrice();
        int inventory = request.getInventory();
        int salesFigures = request.getSalesFigures();
        String category = request.getCategory();
        if (!StringUtils.hasText(isbn) || !StringUtils.hasText(bookName) || !StringUtils.hasText(author) || price <= 0 ||
            inventory < 0 || salesFigures < 0 ||!StringUtils.hasText(category) ){
             return new BookResponse(RtnCode.DATA_ERROR.getMessage());//Data Error
        }//Todo isbn格式正規表達
        Book result = new Book(isbn,bookName,author,price,inventory,salesFigures,category);
        bookDao.save(result);
        return new BookResponse(result,RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public BookResponse searchBookByCategory(BookRequest request) {
//    String category = request.getCategory();
//    if (!StringUtils.hasText(category)){
//        return new BookResponse(RtnCode.CANNOT_EMPTY.getMessage());
//    }
//        List<Book> result = bookDao.searchByType(category);
//        return new BookResponse(RtnCode.SUCCESSFUL.getMessage(),result);
        return null;
    }

    @Override
    public BookResponse searchBookAccordingBy(BookRequest request) {//search By book name or ISBN OR author
//    String bookName = request.getBookName();
//    String isbn = request.getIsbn();
//    String author = request.getAuthor();
//    String identity = request.getIdentity();
//    if (!StringUtils.hasText(bookName) || !StringUtils.hasText(isbn) || !StringUtils.hasText(author)
//        || !StringUtils.hasText(identity)){
//        return new BookResponse(RtnCode.CANNOT_EMPTY.getMessage());
//    }
//    String customerPattern = "消費者";
//    String venderPattern = "書籍商";
//    if (identity.matches(customerPattern)){
//
//
//    }
//    if (identity.matches(venderPattern)){
//
//    }

        return null;
    }
}
