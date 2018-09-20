package com.jianjieming.homework;

/**
 * @author 铭
 */
public class Test02 {
    public static void main(String[] args) {
        String s = "name=张三,age=15,height=1.8 name=李四,age=20,height=1.6 name=王五,age=21,height=1.9";

        String[] split = s.split(" ");
        Person[] persons = new Person[split.length];

        for (int i = 0; i < split.length; i++) {
            Person p = new Person();
            String ss = split[i];
            String[] split1 = ss.split("[=,]");
            p.setName(split1[1]);
            p.setAge(Integer.parseInt(split1[3]));
            p.setHeight(Float.parseFloat(split1[5]));
            persons[i] = p;
        }
        for (int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].getName() + "  "
                    + persons[i].getAge() + "    "
                    + persons[i].getHeight());
        }
    }
}
