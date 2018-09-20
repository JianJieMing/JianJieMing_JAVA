package com.jianjieming.Test;

/**
 * @author 铭
 */
public class Student implements Cloneable {
    private int age;
    private Message message;

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", message=" + message +
                '}';
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Object clone() {
        Student stu = null;
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (message != null) {
            stu.message = (Message) message.clone();
        }
        return stu;
    }
}
