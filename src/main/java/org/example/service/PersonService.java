package org.example.service;

import org.example.model.entity.Person;

import java.util.List;

public interface PersonService {

    Person create(Person person);

    Person readById(long id);

    List<Person> readAll();

    Person update(Person person);

    void deleteById(long id);
}
