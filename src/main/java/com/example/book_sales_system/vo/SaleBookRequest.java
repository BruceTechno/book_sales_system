package com.example.book_sales_system.vo;

import java.util.List;

public class SaleBookRequest {
    List<String> saleBookList;
//==========================================================================================

    public SaleBookRequest() {
    }

    public SaleBookRequest(List<String> saleBookList) {
        this.saleBookList = saleBookList;
    }
//==========================================================================================

    public List<String> getSaleBookList() {
        return saleBookList;
    }

    public void setSaleBookList(List<String> saleBookList) {
        this.saleBookList = saleBookList;
    }
}
