package com.example.book_sales_system.repository;

import com.example.book_sales_system.entity.Book;
import com.example.book_sales_system.vo.CategoryResponse;
import com.example.book_sales_system.vo.CustomerResponse;
import com.example.book_sales_system.vo.VenderResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface BookDao extends JpaRepository<Book,String> {
    @Transactional
    @Modifying
    @Query("select new com.example.book_sales_system.vo.CategoryResponse(b.bookName,b.author,b.price,b.inventory)" +
            " from Book b" +
            " where b.category like concat ('%',:newInput,'%')")
    public List<CategoryResponse> searchByType(@Param("newInput")String input);
    @Transactional
    @Modifying
    @Query("select new com.example.book_sales_system.vo.CustomerResponse(b.bookName,b.isbn,b.author,b.price)" +
            " from Book b" +
            " where b.isbn like concat('%',:inputKeyword,'%') or" +
            " b.author like concat('%',:inputKeyword,'%') or" +
            " b.bookName like concat('%',:inputKeyword,'%')")
    public List<CustomerResponse> customerSearchByNameORIsbnOrAuthor(@Param("inputKeyword")String keyword);

    @Transactional
    @Modifying
    @Query("select new com.example.book_sales_system.vo.VenderResponse(b.isbn,b.bookName,b.author,b.price,b.inventory,b.salesFigures)" +
            " from Book b" +
            " where b.isbn like concat('%',:inputKeyword,'%') or" +
            " b.author like concat('%',:inputKeyword,'%') or" +
            " b.bookName like concat('%',:inputKeyword,'%')")
    public List<VenderResponse> venderSearchByNameORIsbnOrAuthor(@Param("inputKeyword")String keyword);
    @Transactional
    @Modifying
    @Query("update Book b set b.inventory = :newInventory , b.category = :newCategory , b.price = :newPrice  where b.isbn = :newIsbn")
    public int updateBookInventory(
            @Param("newInventory")String inventory,
            @Param("newCategory")String category,
            @Param("newPrice")int price,
            @Param("newIsbn")String isbn);
    //todo updateInfo by WHAT?????? done

}
/*
* 更新書籍資料
庫存量(進貨): 顯示書名、ISBN、作者、價格、庫存量
價格: 顯示書名、ISBN、作者、價格、庫存量
分類: 顯示書名、ISBN、作者、價格、分類
* */
//is customer >>boolean 0or1
//開一個新的class 放那四個一樣的' 再開一個新的class 繼承前面那一個 然後再多兩個 當書籍商的class 回傳方法型態變成泛型
//或者 response 放8ㄍ欄位 六個基本的 另外兩個式整合起來成為 書籍商(6) 跟 消費者(4)的

//todo request分門別類 每一個API放一個request