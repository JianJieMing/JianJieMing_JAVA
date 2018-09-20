package com.jianjieming.homework;

public class Test02 {
    public static void main(String[] args) {
        String a = "12345";
        int result = 0;
        int r = 1;
        for (int i = a.length() - 1; i >= 0; i--) {
            char ch = a.charAt(i);
            int n = ch - 48;
            result += n * r;
            r *= 10;
        }
        System.out.println(result);
    }
}
