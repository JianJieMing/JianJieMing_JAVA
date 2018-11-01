package com.lanou3g.tokendemo111.utils;

/**
 * @author 铭
 * 2018/11/1 17:21
 */
public class ResuleWrapper {

    private boolean status;
    private int code;
    private String message;
    private Object data;

    public ResuleWrapper() {
    }

    private ResuleWrapper(boolean status, int code, Object message) {

    }

    public ResuleWrapper(boolean status, int code, String message, Object data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResuleWrapper success(Object data) {
        return new ResuleWrapper(true, 200, "OK", data);
    }

    public static ResuleWrapper error(  ) {
        return new ResuleWrapper(false, 666, "用户名或者密码错误");
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
