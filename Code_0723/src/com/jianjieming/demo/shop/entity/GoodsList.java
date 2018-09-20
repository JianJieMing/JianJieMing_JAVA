package com.jianjieming.demo.shop.entity;

/**
 * 商品清单类, 用来保存清单名称和清单路径
 */
public class GoodsList {
    /** 清单名称 */
    private String name;
    /** 清单路径 */
    private String path;

    public GoodsList(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
