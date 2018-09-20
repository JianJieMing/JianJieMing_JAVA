package com.jianjieming.Test01.Modle.dao;

import com.jianjieming.Test01.Modle.vo.Animal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 下午8:00
 */
@Repository
public class PersonDaoImpl implements PersonDao {
    @Override
    public List<Animal> animalList() {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Animal animal = new Animal("旺财"+i,1+i);
            animals.add(animal);
        }
        return animals;
    }
}
