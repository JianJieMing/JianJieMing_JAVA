package com.jianjieming.study.exception;

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
