package com.jianjieming.learning;

/**
 * @author 铭
 */
public class MyCollection {


    public static void sort(MyComparable[] array) {
        /*
            对数组中的元素进行排序.
         */
        for (int i = 0; i < array.length - 1; i++) {
            for (int i1 = 0; i1 < array.length - i - 1; i1++) {
//                if (persons[i1].getAge() > persons[i1 + 1].getAge()) {
                if (array[i1].compareTo(array[i1 + 1]) > 0) {
                    MyComparable temp = array[i1];
                    array[i1] = array[i1 + 1];
                    array[i1 + 1] = temp;
                }
            }
        }
    }


    public static <T> void sort(T[] array, MyComparator<T> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int i1 = 0; i1 < array.length - i - 1; i1++) {
                if (comparator.compare(array[i1], array[i1 + 1]) > 0) {
                    T temp = array[i1];
                    array[i1] = array[i1 + 1];
                    array[i1 + 1] = temp;
                }
            }
        }
    }
}

