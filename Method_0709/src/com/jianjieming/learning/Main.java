package com.jianjieming.learning;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
//        调用某个方法的时候,必须按照声明时的参数规则,填写参数.

//        将某个方法的返回值赋值给一个变量.
//        System.out.println("请输入需要计算的第一个算: ");
//        int x = scanner.nextInt();
//        System.out.println("请输入需要计算的第二个算: ");
//        int y = scanner.nextInt();

//        在调用的时候传递的是什么参数,
//        那么在这次的调用中,形参的值就是什么.
//        int sum = calculator.add(x, y);
//        System.out.println(x + " + " + y + " = " + sum);

        Person person = new Person();
//        person.name = "佐助";
//        person.age = 21;
        person.setName("张三");
        person.setAge(23);
        System.out.println(person.getName() + "年龄: " + person.getAge());
    }
}
