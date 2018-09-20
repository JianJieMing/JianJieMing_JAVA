package com.jianjieming.study.common;

import java.util.List;

/**
 * @author 铭
 */
public class Pageable<T> {

    // 总页数
    private int totalCount;
    // 查出来的数据
    private List<T> items;

    public Pageable() {
    }

    public Pageable(int totalCount, List<T> items) {
        this.totalCount = totalCount;
        this.items = items;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
