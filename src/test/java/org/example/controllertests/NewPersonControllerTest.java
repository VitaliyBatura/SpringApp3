package org.example.controllertests;

import org.example.controller.PersonController;
import org.example.model.entity.Person;
import org.example.model.mapper.PersonMapper;
import org.example.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class NewPersonControllerTest {

    @Mock
    private PersonService personService;
    @Spy
    private PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);
    @InjectMocks
    private PersonController personController;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(personController)
                .defaultRequest(get("/")
                        .accept(MediaType.APPLICATION_JSON))
                .alwaysExpect(status().isOk())
                .alwaysExpect(content()
                        .contentType("application/json"))
                .build();
    }

    private List<Person> getPersons() {
        Person person1 = new Person(1L, "Ivan", "Petrov");
        Person person2 = new Person(2l, "Stepan", "Sergeev");
        return List.of(person1, person2);
    }

    @Test
    void createPerson() throws Exception {
        Person newPerson = new Person("Ivan", "Petrov");
        when(personService.create(any(Person.class))).thenReturn(newPerson);
        mockMvc.perform(post("/api/persons")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(newPerson))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Ivan"))
                .andExpect(jsonPath("$.lastName").value("Petrov"));
        verify(personService).create(any(Person.class));
    }

    @Test
    void readOnePerson() throws Exception {
        when(this.personService.readById(1L)).thenReturn(getPersons().get(0));
        mockMvc.perform(get("/api/persons/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.firstName").value("Ivan"))
                .andExpect(jsonPath("$.lastName").value("Petrov"));
        verify(personMapper).toPersonDto(any(Person.class));
    }

    @Test
    void readAllPersons() throws Exception {
        when(this.personService.readAll()).thenReturn(getPersons());
        mockMvc.perform(get("/api/persons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void updatePerson() throws Exception {
        Person newPerson = new Person(1L, "Sergey", "Sergeev");
        when(personService.update(any(Long.class), any(Person.class))).thenReturn(newPerson);
        mockMvc.perform(put("/api/persons/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(newPerson))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Sergey"))
                .andExpect(jsonPath("$.lastName").value("Sergeev"));
        verify(personService).update(any(Long.class), any(Person.class));
    }

    @Test
    public void deletePerson() throws Exception {
        doNothing().when(personService).deleteById(any(Long.class));
        mockMvc.perform(delete("/api/persons/{id}", 1))
                .andExpect(status().isOk());
        verify(personService).deleteById(any(Long.class));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
