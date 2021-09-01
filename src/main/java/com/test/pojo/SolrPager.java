package com.test.pojo;

import java.util.List;

public class SolrPager {

    private int pageIndex;//当前页页码

    private int pageSize;//每页大小

    private int pageCount;//总页数

    private long recordCount;//总记录数

    private List<Goods> GoodsList;//当前页数据

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public long getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;
    }

    public List<Goods> getGoodsList() {
        return GoodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        GoodsList = goodsList;
    }
}
