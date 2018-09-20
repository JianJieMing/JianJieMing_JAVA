package com.jianjieming.Test01.Modle.service;

import com.jianjieming.Test01.Modle.dao.PersonDaoImpl;
import com.jianjieming.Test01.Modle.vo.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 铭
 * DATE: 18/9/12 下午7:57
 */
@Service
public class PersonService {
    @Autowired
    private PersonDaoImpl personDao;

    public List<Animal> showAll() {
        List<Animal> animals = personDao.animalList();
        return animals;
    }

    @Override
    public String toString() {
        return "PersonService{" +
                "personDao=" + personDao +
                '}';
    }
}
