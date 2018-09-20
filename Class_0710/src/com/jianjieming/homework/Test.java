package com.jianjieming.homework;

/**
 * @author 铭
 */
public class Test {
    public static void main(String[] args) {
        String s = "name=张三,age=15,height=1.8 name=李四,age=20,height=1.6 name=王五,age=21,height=1.9";
        String[] strings = s.split(" ");
        Person[] people = new Person[strings.length];
        int i = 0;
        for (String s1 : strings) {
            String[] strings1 = s1.split(",");
            Person person = new Person();
            for (String s2 : strings1) {
                String[] strings2 = s2.split("=");
                if (strings2[0].equals("name")) {
                    person.setName(strings2[1]);
                } else if (strings2[0].equals("age")) {
                    person.setAge(Integer.valueOf(strings2[1]));
                } else if (strings2[0].equals("height")) {
                    person.setHeight(Float.valueOf(strings2[1]));
                }
            }
            people[i] = person;
            i++;
            System.out.println(person);
        }


    }
}
