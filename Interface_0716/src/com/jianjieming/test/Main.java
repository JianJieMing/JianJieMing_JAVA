package com.jianjieming.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
//        /**
//         * 加法
//         */
//        Computable c1 = new AddComputer();
//        int result1 = c1.compute(1, 2);
//        System.out.println(result1);
//        /**
//         * 减法
//         */
//        Computable c2 = new SubtractComputer();
//        int result2 = c2.compute(4, 1);
//        System.out.println(result2);
//        /**
//         * 乘法
//         */
//        Computable c3 = new MultiplicationComputer();
//        int result3 = c3.compute(2, 5);
//        System.out.println(result3);
//        /**
//         * 除法
//         */
//        Computable c4 = new DivisionComputer();
//        int result4 = c4.compute(100, 2);
//        System.out.println(result4);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个整数: ");
        int x = scanner.nextInt();
        System.out.println("请输入第二个整数: ");
        int y = scanner.nextInt();
        System.out.println("请输入运算符: ");
        String s = scanner.next();

//        int result = 0;
//        switch (s) {
//            case "+":
//                result = x + y;
//                break;
//            case "-":
//                result = x - y;
//                break;
//            case "*":
//                result = x * y;
//                break;
//            case "/":
//                result = x / y;
//                break;
//        }

        int result = 0;
        Computable c = null;
//        switch (s) {
//            case "+":
//                c = new AddComputer();
//                break;
//            case "-":
//                c = new SubtractComputer();
//                break;
//            case "*":
//                c = new MultiplicationComputer();
//                break;
//            case "/":
//                c = new DivisionComputer();
//                break;
//        }

        Map<String, Computable> cm = new HashMap<>();
        cm.put("+", new AddComputer());
        cm.put("-", new SubtractComputer());
        cm.put("*", new MultiplicationComputer());
        cm.put("/", new DivisionComputer());

        Computable computable = cm.get(s);

        if (computable != null) {
            result = computable.compute(x, y);
        }
        System.out.println(result);
    }
}
