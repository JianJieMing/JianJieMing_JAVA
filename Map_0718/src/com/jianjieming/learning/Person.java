package com.jianjieming.learning;

/**
 * @author 铭
 */
public class Person {
    //     implements MyComparable<Person>
    private String name;
    private int age;
    private float weight;
    private float height;

    public Person() {
    }

    public Person(String name, int age, float weight, float height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                '}' + '\n';
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

//    @Override
//    public int compareTo(Person other) {
//        if (this.age < other.age) {
//            return -1;
//        } else if (this.age > other.age) {
//            return 1;
//        }
//        return 0;
//    }
}
