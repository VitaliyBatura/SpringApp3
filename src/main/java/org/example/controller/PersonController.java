package org.example.controller;

import org.example.model.dto.PersonDto;
//import org.example.model.mapper.PersonListMapper;
import org.example.model.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.model.entity.Person;
import org.example.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    private PersonService personService;
    private PersonMapper personMapper;

    @Autowired
    public PersonController(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    @PostMapping("/persons")
    public PersonDto createPerson(@RequestBody PersonDto personDto) {
        Person person = personMapper.toPerson(personDto);
        return personMapper.toPersonDto(personService.create(person));
    }

    @GetMapping("/persons/{id}")
    public PersonDto readOnePerson(@PathVariable Long id) {
        Person person = personService.readById(id);
        return  personMapper.toPersonDto(person);
    }

    @GetMapping("/persons")
    public List<PersonDto> readAllPersons() {
        List<Person> persons = personService.readAll();
        return personMapper.toPersonDtoList(persons);
    }

    @PutMapping("/persons/{id}")
    public PersonDto updatePerson(@PathVariable Long id, @RequestBody PersonDto personDto) {
        Person person = personMapper.toPerson(personDto);
        return personMapper.toPersonDto(personService.update(id, person));
    }

    @DeleteMapping("/persons/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
        return "Person with ID = " + id + " was deleted";
    }
}
