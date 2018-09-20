package com.jianjieming.Test;

public class Test04 {
    public static void main(String[] args) {
        System.out.println("质因数分解");
        int n = 7800;
        for (int i = 2; n > 1; i++) {
            if (n % i == 0){
                n = n / i;
                System.out.println(i + " ");
                i = 1;
            }
        }
    }
}
