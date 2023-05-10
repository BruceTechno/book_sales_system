package com.example.book_sales_system.service.impl;

import com.example.book_sales_system.constants.RtnCode;
import com.example.book_sales_system.entity.Book;
import com.example.book_sales_system.entity.ShenHeBook;
import com.example.book_sales_system.repository.BookDao;
import com.example.book_sales_system.service.ifs.BookService;
import com.example.book_sales_system.service.ifs.TopFiveProjection;
import com.example.book_sales_system.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;
import java.util.List;
import java.util.Optional;

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
                inventory < 0 || salesFigures < 0 || !StringUtils.hasText(category)) {
            return new BookResponse(RtnCode.DATA_ERROR.getMessage());//Data Error
        }//Todo isbn格式正規表達
        Book result = new Book(isbn, bookName, author, price, inventory, salesFigures, category);
        bookDao.save(result);
        return new BookResponse(result, RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public BookResponse searchBookByCategory(BookRequest request) {
        String category = request.getCategory();
        if (!StringUtils.hasText(category)) {
            return new BookResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        List<CategoryResponse> result = bookDao.searchByType(category);
        return new BookResponse(RtnCode.SUCCESSFUL.getMessage(), result);
//        return null;
    }

    @Override //
    public BookResponse searchBookAccordingBy(BookRequest request) {//search By book name or ISBN OR author
        String identity = request.getIdentity();

//        String bookName = request.getBookName();
//        String isbn = request.getIsbn();
//        String author = request.getAuthor();
        String keyword = request.getKeyword();//keyword could be  bookName or isbn or author
        if (!StringUtils.hasText(identity) || !StringUtils.hasText(keyword)) {
            return new BookResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        String customerPattern = "消費者";
        String venderPattern = "書籍商";
        if (identity.matches(customerPattern)) {
            List<CustomerResponse> customerResult = bookDao.customerSearchByNameORIsbnOrAuthor(keyword);
            if (CollectionUtils.isEmpty(customerResult)) {
                return new BookResponse(RtnCode.NOT_FOUND.getMessage());//找不到這本書
            }
            return new BookResponse(RtnCode.SUCCESSFUL.getMessage(), customerResult);
        }
        if (identity.matches(venderPattern)) {
            List<VenderResponse> venderResult = bookDao.venderSearchByNameORIsbnOrAuthor(keyword);
            if (CollectionUtils.isEmpty(venderResult)) {
                return new BookResponse(RtnCode.NOT_FOUND.getMessage());
            }

            return new BookResponse(RtnCode.SUCCESSFUL.getMessage(), venderResult);
        }
        return null;
    }//todo BookResponse無法同時放List<CustomerResponse> List<VenderResponse> done

    @Override
    public BookResponse updateInventory(BookRequest request) {
        int inventory = request.getInventory();
        String isbn = request.getIsbn();
        if (inventory < 0 || !StringUtils.hasText(isbn)) {
            return new BookResponse(RtnCode.DATA_ERROR.getMessage());
        }
        int result = bookDao.updateInventory(inventory, isbn);
        if (result == 0) {
            return new BookResponse(RtnCode.NOT_FOUND.getMessage());
        }
        Optional<Book> bookInfo = bookDao.findById(isbn);
        Book bookResult = new Book(bookInfo.get().getIsbn(), bookInfo.get().getBookName(), bookInfo.get().getAuthor(), bookInfo.get().getPrice());
        return new BookResponse(bookResult, RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public BookResponse updatePrice(BookRequest request) {
        int price = request.getPrice();
        String isbn = request.getIsbn();
        if (price < 0 || !StringUtils.hasText(isbn)) {
            return new BookResponse(RtnCode.DATA_ERROR.getMessage());
        }
        int result = bookDao.updatePrice(price, isbn);
        if (result == 0) {
            return new BookResponse(RtnCode.NOT_FOUND.getMessage());
        }
        Optional<Book> bookInfo = bookDao.findById(isbn);
        Book bookResult = new Book(bookInfo.get().getIsbn(), bookInfo.get().getBookName(), bookInfo.get().getAuthor(), bookInfo.get().getPrice());
        return new BookResponse(bookResult, RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public BookResponse updateCategory(BookRequest request) {
        String category = request.getCategory();
        String isbn = request.getIsbn();
        if (!StringUtils.hasText(isbn) || !StringUtils.hasText(category)) {
            return new BookResponse(RtnCode.DATA_ERROR.getMessage());
        }
        int result = bookDao.updateCategory(category, isbn);
        if (result == 0) {
            return new BookResponse(RtnCode.NOT_FOUND.getMessage());
        }
        Optional<Book> bookInfo = bookDao.findById(isbn);
        Book bookResult = new Book(bookInfo.get().getIsbn(), bookInfo.get().getBookName(), bookInfo.get().getAuthor(), bookInfo.get().getPrice());
        return new BookResponse(bookResult, RtnCode.SUCCESSFUL.getMessage());
    }

    @Override
    public BookResponse saleBooks(SaleBookRequest request) {
        List<String> saleBookList = request.getSaleBookList(); //enter isbn to buy the books?????
        if (CollectionUtils.isEmpty(saleBookList)) {
            return new BookResponse(RtnCode.CANNOT_EMPTY.getMessage());
        }
        List<Book> sellBooksInfo = bookDao.findAllById(saleBookList);
        if (CollectionUtils.isEmpty(sellBooksInfo)) {
            return new BookResponse(RtnCode.NOT_FOUND.getMessage());//沒有這些書可以賣
        }
        for (Book item : sellBooksInfo) {
            item.setSalesFigures(item.getSalesFigures() + 1);
            item.setInventory(item.getInventory() - 1);
        }
        bookDao.saveAll(sellBooksInfo);
        return new BookResponse(RtnCode.SUCCESSFUL.getMessage(), sellBooksInfo);
    }

    @Override
    public BookResponse findTopFiveBooks(TopFiveBooksRequest request) {
        int limitNum = request.getLimitNum();
        if (limitNum < 0 ){
            return new BookResponse(RtnCode.DATA_ERROR.getMessage());
        }
        List<Book> result = bookDao.searchTopBooks(limitNum);
        if (CollectionUtils.isEmpty(result)){
            return new BookResponse(RtnCode.NOT_FOUND.getMessage());
        }
        for (Book item : result){
            item.setCategory(null);
            item.setSalesFigures(0);
            item.setInventory(0);
        }

        return new BookResponse(RtnCode.SUCCESSFUL.getMessage(),result);
    }
}
