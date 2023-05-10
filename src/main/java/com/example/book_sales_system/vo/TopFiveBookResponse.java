package com.example.book_sales_system.vo;

import com.example.book_sales_system.service.ifs.TopFiveProjection;

import java.util.List;

public class TopFiveBookResponse {
    private String message;
    private List<TopFiveProjection> topFiveProjectionList;
//=====================================================================

    public TopFiveBookResponse() {
    }

    public TopFiveBookResponse(String message, List<TopFiveProjection> topFiveProjectionList) {
        this.message = message;
        this.topFiveProjectionList = topFiveProjectionList;
    }
    //=====================================================================

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<TopFiveProjection> getTopFiveProjectionList() {
        return topFiveProjectionList;
    }

    public void setTopFiveProjectionList(List<TopFiveProjection> topFiveProjectionList) {
        this.topFiveProjectionList = topFiveProjectionList;
    }
}
