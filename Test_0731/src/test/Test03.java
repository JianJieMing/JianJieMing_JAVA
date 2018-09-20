package test;

import java.util.Arrays;

/**
 * @author 铭
 */
public class Test03 {
    public static void main(String[] args) {
        //需要进行排序的数组
        int[] array = new int[]{8, 3, 2, 1, 7, 4, 6, 5};
        int[] array2 = new int[]{8, 3, 2, 1, 7, 4, 6, 5};
        directInsertSort(array2);
        System.out.println(Arrays.toString(array2));
    }


    /**
     * 直接插入排序的方法
     *
     * @param array
     */
    private static void directInsertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    System.arraycopy(array, j, array, j + 1, i - j);
                    array[j] = temp;
                }
            }
        }
    }

}
