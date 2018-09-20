package com.jianjieming.Test;

import java.util.Arrays;

public class Test09{
    public static void main (String[] args){
        int[] array = {1, 3, 6, 2, 5, 4};
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] <  array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
