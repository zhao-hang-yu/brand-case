package com.pojo;

import java.util.List;

//分页查询的JavaBean
public class PageBean<T> {
    //总记录数
    private long totalCount;
    //当前页数据
    private List<T> rows;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
