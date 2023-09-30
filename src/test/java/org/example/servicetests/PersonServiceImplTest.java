package org.example.servicetests;

import org.example.model.entity.Person;
import org.example.model.repository.PersonRepository;
import org.example.service.impl.PersonServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class PersonServiceImplTest {

    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    public void create() {
        when(personRepository.save(any(Person.class))).thenReturn(new Person());
        personService.create(new Person());
        verify(personRepository).save(any(Person.class));
    }

    @Test
    public void readById() {
        when(personRepository.findById(any(Long.class))).thenReturn(Optional.of(new Person()));
        personService.readById(1L);
        verify(personRepository).findById(1L);
    }

    @Test
    public void readAll() {
        when(personRepository.findAll()).thenReturn(Collections.emptyList());
        personService.readAll();
        verify(personRepository).findAll();
    }

    @Test
    public void update() {
        Person person = new Person();
        when(personRepository.save(any(Person.class))).thenReturn(person);
        personService.update(13L, person);
        assertEquals(13L, person.getId());
        verify(personRepository).save(any(Person.class));
    }

    @Test
    public void deleteById() {
        doNothing().when(personRepository).deleteById(anyLong());
        personService.deleteById(33L);
        verify(personRepository).deleteById(33L);
    }
}
