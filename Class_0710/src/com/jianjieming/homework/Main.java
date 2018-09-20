package com.jianjieming.homework;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        String[] ww = {String.valueOf(person1), String.valueOf(person2), String.valueOf(person3)};
        String ss = "name=张三,age=15,height=1.8 name=李四,age=20,height=1.6 name=王五,age=21,height=1.9";
        String[] split = ss.split("[ ]");
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < split.length; i++) {
            ww[i] = split[i];
            sb.append(split[i]);
        }
        String sb2 = sb.toString();
        String[] split1 = sb2.split("[= | ,]");
        String[] split2 = sb2.split("[name= | age= | height= | ,]+");
        for (int i = 1; i < split2.length; i++) {

            if (i == 1) {
                person1.setName(split2[i]);
                System.out.println(person1.getName());
            }
            if (i == 2) {
                Integer ee = Integer.parseInt(split2[i]);
                person1.setAge(ee);
                System.out.println(person1.getAge());
            }
            if (i == 3) {
                Float rr = Float.parseFloat(split2[i]);
                person1.setHeight(rr);
                System.out.println(person1.getHeight());
            }
            if (i == 4) {
                person2.setName(split2[i]);
                System.out.println(person2.getName());
            }
            if (i == 5) {
                Integer ee = Integer.parseInt(split2[i]);
                person2.setAge(ee);
                System.out.println(person2.getAge());
            }
            if (i == 6) {
                Float rr = Float.parseFloat(split2[i]);
                person2.setHeight(rr);
                System.out.println(person2.getHeight());
            }
            if (i == 7) {
                person3.setName(split2[i]);
                System.out.println(person3.getName());
            }
            if (i == 8) {
                Integer ee = Integer.parseInt(split2[i]);
                person3.setAge(ee);
                System.out.println(person3.getAge());
            }
            if (i == 9) {
                Float rr = Float.parseFloat(split2[i]);
                person3.setHeight(rr);
                System.out.println(person3.getHeight());
            }
        }
    }
}
