package org.example.controllertests;

import org.example.controller.PersonController;
import org.example.model.dto.PersonDto;
import org.example.model.entity.Person;
import org.example.model.mapper.PersonMapper;
import org.example.service.PersonService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonControllerTest {

    @Mock
    private PersonService personService;
    @Spy
    private PersonMapper personMapper;
    @InjectMocks
    private PersonController personController;

    @Test
    public void createPerson() {
        when(personService.create(any(Person.class))).thenReturn(new Person());
        personController.createPerson(new PersonDto());
        verify(personMapper).toPerson(any(PersonDto.class));
        verify(personService).create(any(Person.class));
        verify(personMapper).toPersonDto(any(Person.class));
    }

    @Test
    public void readOnePerson() {
        when(personService.readById(any(Long.class))).thenReturn((new Person()));
        personController.readOnePerson(1L);
        verify(personService).readById(1L);
        verify(personMapper).toPersonDto(any(Person.class));
    }

    @Test
    public void readAllPersons() {
        when(personService.readAll()).thenReturn(Collections.emptyList());
        personController.readAllPersons();
        verify(personService).readAll();
        verify(personMapper).toPersonDtoList(any());
    }

    @Test
    public void updatePerson() {
        when(personService.update(any(Long.class), any(Person.class))).thenReturn(new Person());
        personController.updatePerson(1L, new PersonDto());
        verify(personMapper).toPerson(any(PersonDto.class));
        verify(personService).update(any(Long.class), any(Person.class));
        verify(personMapper).toPersonDto(any(Person.class));
    }

    @Test
    public void deletePerson() {
        doNothing().when(personService).deleteById(any(Long.class));
        personController.deletePerson(1L);
        verify(personService).deleteById(any(Long.class));
    }
}
