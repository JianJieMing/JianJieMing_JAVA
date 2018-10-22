package com.lanou3g.springbootdemo.base;

import java.io.Serializable;

/**
 * @author 铭
 * 2018/10/20 15:17
 */
public class BaseEntity implements Serializable {
    /**
     * <p>
     * 分页页码,默认页码为1
     * <p>
     */
    protected int page = 1;

    /**
     * <p>
     * 分页每页数量,默认20条
     * <p>
     */
    protected int size = 5;

    /**
     * <p>
     * 排序列名称,默认为id
     * <p>
     */
    protected String sidx = "adminId";

    /**
     * <p>
     * 排序正序
     * <p>
     */
    protected String sord = "asc";

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }

}
