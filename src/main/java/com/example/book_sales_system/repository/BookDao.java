package com.example.book_sales_system.repository;

import com.example.book_sales_system.entity.Book;
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
            " where b.category like concat('%',:inputCategory,'%'")
    public List<Book> searchByType(@Param("inputCategory")String category);
//    @Transactional
//    @Modifying
//    @Query("select new com.example.book_sales_system.vo.CustomerResponse(b.bookName,b.isbn,b.author,b.price)" +
//            " from Book b" +
//            " where b.isbn like concat('%',:inputKeyword'%') or" +
//            " b.author like concat('%',:inputKeyword'%')" +
//            " b.bookName like concat('%',:inputKeyword'%')")
//    public List<Book> searchByNameORIsbnOrAuthor(@Param("inputKeyword")String keyword);

}
