package com.ederrafo.service;

import com.ederrafo.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//La anotamos como Service, para que se genera como un bean en el arranque del servidor app
@Service("personServiceImpl")
public class PersonServiceImpl implements PersonService {

    @Override
    public List<Person> getAllPerson() {
        List<Person> peoples = new ArrayList<>();
        peoples.add(new Person("Eder Rafo", 34));
        peoples.add(new Person("Karina Noelia", 33));
        peoples.add(new Person("Oliver Rafo", 43));
        peoples.add(new Person("Feli Espinhal", 24));
        peoples.add(new Person("Lari Pariwana", 24));
        peoples.add(new Person("Pariwana", 24));

        return peoples;
    }
}
