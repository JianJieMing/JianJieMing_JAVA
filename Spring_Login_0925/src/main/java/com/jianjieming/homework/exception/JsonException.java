package com.jianjieming.homework.exception;

/**
 * @author 铭
 * 2018/9/25 9:52
 */
public class JsonException extends BaseException {

    private int code;

    public JsonException(int code) {
        this.code = code;
    }

    public JsonException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
