package org.example.repositorytests;

import org.example.configuration.Config;
import org.example.model.entity.Person;
import org.example.model.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(classes = {Config.class, PersonRepository.class})
public class PersonRepositoryTest {

    private final PersonRepository personRepository;

    @Autowired
    public PersonRepositoryTest(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Test
    @Sql("/db.sql")
    public void findById() {
        Person person1 = new Person();
        person1.setFirstName("Ivan");
        person1.setLastName("Petrov");
        person1 = personRepository.save(person1);
        Person person2 = new Person();
        person2.setFirstName("Stepan");
        person2.setLastName("Sidorov");
        person2 = personRepository.save(person2);
        Person person3 = new Person();
        person3.setFirstName("Dmitriy");
        person3.setLastName("Popov");
        person3 = personRepository.save(person3);
        Person currentPerson1 = personRepository.findById(person1.getId()).orElseThrow();
        Person currentPerson2 = personRepository.findById(person1.getId()).orElseThrow();
        Person currentPerson3 = personRepository.findById(person1.getId()).orElseThrow();
        List<Person> persons = new ArrayList<>();
        persons.add(currentPerson1);
        persons.add(currentPerson2);
        persons.add(currentPerson3);
        assertEquals(3, persons.size());
        assertTrue(persons.contains(currentPerson1));
        assertTrue(persons.contains(currentPerson3));
        personRepository.delete(person1);
        personRepository.delete(person2);
        personRepository.delete(person3);
    }
}
