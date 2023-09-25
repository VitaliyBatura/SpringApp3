package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.exception_handling.NoSuchPersonException;
import org.example.model.entity.Person;
import org.example.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person person) {
        personService.create(person);
        return person;
    }

    @GetMapping("/persons/{id}")
    public Person readOnePerson(@PathVariable long id) {
        Person person = personService.readById(id);
        if(person == null) {
            throw new NoSuchPersonException("There is no person with ID = " + id + " in Database");
        }
        return  person;
    }

    @GetMapping("/persons")
    public List<Person> readAllPersons() {
        List<Person> persons = personService.readAll();
        return persons;
    }

    @PutMapping("/persons")
    public Person updatePerson(@RequestBody Person person) {
        personService.create(person);
        return person;
    }

    @DeleteMapping("/persons/{id}")
    public String delete(@PathVariable long id) {
        Person person = personService.readById(id);
        if(person == null) {
            throw new NoSuchPersonException("There is no person with ID = " + id + " in Database");
        }
        personService.deleteById(id);
        return "Person with ID = " + id + " was deleted";
    }
}
