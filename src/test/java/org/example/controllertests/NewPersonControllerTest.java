package org.example.controllertests;

import org.example.controller.PersonController;
import org.example.model.entity.Person;
import org.example.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;
import org.testcontainers.shaded.com.google.common.net.MediaType;

import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = PersonController.class)
public class NewPersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    private List<Person> getPersons() {
        Person person1 = new Person("Ivan", "Petrov");
        Person person2 = new Person("Stepan", "Sergeev");
        return List.of(person1, person2);
    }

 //   @Test
//    void createPerson() throws Exception {
////        when(this.personService.create(new Person("Ivan", "Petrov")))
////                .thenReturn(getPersons().get(0));
//        mockMvc.perform(MockMvcRequestBuilders
//                .post("/persons"))
//                .content(asJsonString(new Person("Ivan", "Petrov")))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
////                .andExpect(jsonPath("$.id").value(1))
////                .andExpect(jsonPath("$.first_name").value("Ivan"))
////                .andExpect(jsonPath("$.last_name").value("Petrov"));
//    }

//    @Test
//    public void createEmployeeAPI() throws Exception
//    {
//        mvc.perform( MockMvcRequestBuilders
//                        .post("/employees")
//                        .content(asJsonString(new EmployeeVO(null, "firstName4", "lastName4", "email4@mail.com")))
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists());
//    }

    @Test
    void readOnePerson() throws Exception {
        when(this.personService.readById(1L)).thenReturn(getPersons().get(0));
        mockMvc.perform(get("/persons/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.first_name").value("Ivan"))
                .andExpect(jsonPath("$.last_name").value("Petrov"));
    }

    @Test
    void readAllPersons() throws Exception {
        when(this.personService.readAll()).thenReturn(getPersons());
        mockMvc.perform(get("/persons"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

    }

//    @Test
//    void updatePerson() {
//        when(this.personService.update(new Person(1L, "Ivan", "Frolov")))
//                .thenReturn(any(Person.class));
//
//    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
