package com.jianjieming.java;

/**
 * @author 铭
 */
public class User {
    private String uUsername;
    private String uPassword;
    private String uWord;

    @Override
    public String toString() {
        return "User{" +
                "uUsername='" + uUsername + '\'' +
                ", uPassword='" + uPassword + '\'' +
                ", uWord='" + uWord + '\'' +
                '}';
    }

    public String getuUsername() {
        return uUsername;
    }

    public void setuUsername(String uUsername) {
        this.uUsername = uUsername;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public String getuWord() {
        return uWord;
    }

    public void setuWord(String uWord) {
        this.uWord = uWord;
    }
}
