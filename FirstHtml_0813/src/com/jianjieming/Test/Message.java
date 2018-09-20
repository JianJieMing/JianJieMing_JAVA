package com.jianjieming.Test;

/**
 * @author 铭
 */
public class Message implements Cloneable {
    private String personal;

    @Override
    public String toString() {
        return "Message{" +
                "personal=" + personal +
                '}';
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
