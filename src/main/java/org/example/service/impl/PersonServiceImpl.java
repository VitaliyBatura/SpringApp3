package org.example.service.impl;

import org.example.model.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.example.model.entity.Person;
import org.example.service.PersonService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    @Transactional
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public Person readById(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    @Override
    @Transactional
    public List<Person> readAll() {
        return new ArrayList<>((Collection) personRepository.findAll());
    }

    @Override
    @Transactional
    public Person update(Long id, Person person) {
        person.setId(id);
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}