package com.jianjieming.Test;

import java.util.Arrays;

public class Test10{
    public static void main (String[] args){
        int[] arr = {1,3,5,2,4};
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length -i -1; j++){
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
