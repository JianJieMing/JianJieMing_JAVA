package com.jianjieming.demo.shop.exception;

public class GoodsCartFullException extends RuntimeException {

    public GoodsCartFullException(String cartName) {
        super(cartName + "满了");
    }
}
