package com.jianjieming.learning.demo.compare;

public class MyCollections {

    public static void sort(MyComparable[] array){
        // 对数组中的元素根据年龄排序
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
//                if (array[j].getAge() > array[j + 1].getAge()){
                if (array[j].compareTo(array[j + 1]) > 0){
                    MyComparable temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static <T> void sort(T[] array, MyComparator<T> comparator){
        for (int i = 0; i < array.length -1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
//                if (array[j].getAge() > array[j + 1].getAge()){
                if (comparator.compare(array[j], array[j + 1]) > 0){
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
