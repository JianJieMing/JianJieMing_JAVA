package com.jianjieming.learning.demo;


import com.jianjieming.learning.demo.compare.MyCollections;
import com.jianjieming.learning.demo.compare.MyComparator;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("a张三", 18, 70, 170);
        persons[1] = new Person("d李四", 12, 50, 175);
        persons[2] = new Person("b王二麻子", 66, 70, 160);
        persons[3] = new Person("c小淘气", 8, 48, 182);
        persons[4] = new Person("e高帅", 75, 68, 130);

        MyCollections.sort(persons, new MyComparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });




        System.out.println(Arrays.toString(persons));

    }

}
