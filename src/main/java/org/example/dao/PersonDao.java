package org.example.dao;

import org.example.model.entity.Person;

import java.util.List;

public interface PersonDao {

    Person create(Person person);

    Person readById(long id);

    List<Person> readAll();

    Person update(Person person);

    void deleteById(long id);
}
