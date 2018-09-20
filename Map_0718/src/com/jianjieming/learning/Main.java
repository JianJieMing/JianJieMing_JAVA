package com.jianjieming.learning;

import java.util.Arrays;

/**
 * @author 铭
 */
public class Main {
    public static void main(String[] args) {

        Person[] persons = new Person[5];
        persons[0] = new Person("张三", 38, 74, 170);
        persons[1] = new Person("李四", 27, 80, 179);
        persons[2] = new Person("王五", 52, 94, 181);
        persons[3] = new Person("赵六", 17, 98, 177);
        persons[4] = new Person("田七", 10, 15, 100);

        MyCollection.sort(persons, new MyComparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getWeight() > o2.getWeight()) {
                    return 1;
                } else if (o1.getWeight() < o2.getWeight()) {
                    return -1;
                }
                return 0;
            }
        });


        System.out.println(Arrays.toString(persons));

    }
}
