package com.jianjieming.homework.exception;

/**
 * @author 铭
 * 2018/9/25 9:52
 */
public class BaseException extends RuntimeException {
    public BaseException() {

    }

    public BaseException(String message) {
        super(message);
    }
}
