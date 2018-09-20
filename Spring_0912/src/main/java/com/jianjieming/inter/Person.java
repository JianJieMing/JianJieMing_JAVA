package com.jianjieming.inter;

/**
 * @author 铭
 * DATE: 18/9/12 上午11:17
 */
public class Person {
    private String name;
    private Animal animal;

    public void playWithAnimal() {
        System.out.println(this.name + "play with animal");
        animal.bark();
    }

    public Person() {
    }

    public Person(String name, Animal animal) {
        this.name = name;
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", animal=" + animal +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
