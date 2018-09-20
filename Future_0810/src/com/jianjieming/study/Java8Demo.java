package com.jianjieming.study;

import java.util.Arrays;

/**
 * @author 铭
 */
public class Java8Demo {
    public static void main(String[] args) {
        int[] array = {8, 2, 1, 5, 2, 3, 9, 6, 4};
//        把数组转成 stream
//        Arrays.parallelSort(array);
//        System.out.println(Arrays.toString(array));

        Double v = Arrays.stream(array)
                .parallel() // 把流转成并发流
//                .sorted()
//                .forEach(System.out::println);
                .filter(n -> n % 2 == 1)
//                .sorted()
                .average() // 算平均值
                .getAsDouble();
//                .forEach(System.out::println);
        System.out.println(v);


        AddCalculator calculator = ((x, y) -> x + y);
        int add = calculator.add(10, 20);
        System.out.println(add);

        Calculator c = new Calculator();
        c.fun();

        PPP:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i + j == 15) {
                    break PPP;
                }
            }
        }

    }
}
