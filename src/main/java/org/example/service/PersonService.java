package org.example.service;

import org.example.model.entity.Person;

import java.util.List;

public interface PersonService {

    Person create(Person person);

    Person readById(Long id);

    List<Person> readAll();

    Person update(Long id, Person person);

    void deleteById(Long id);
}
