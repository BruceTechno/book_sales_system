package com.example.book_sales_system.vo;

public class TopFiveBooksRequest {
    private int limitNum;
//================================================================================

    public TopFiveBooksRequest() {
    }

//================================================================================


    public int getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(int limitNum) {
        this.limitNum = limitNum;
    }
}
