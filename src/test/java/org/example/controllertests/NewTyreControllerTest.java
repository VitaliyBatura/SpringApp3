package org.example.controllertests;

import org.example.controller.TyreController;
import org.example.model.entity.Tyre;
import org.example.model.mapper.TyreMapper;
import org.example.service.TyreService;
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

import java.util.List;

import static org.example.controllertests.NewPersonControllerTest.asJsonString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class NewTyreControllerTest {

    @Mock
    private TyreService tyreService;
    @Spy
    private TyreMapper tyreMapper = Mappers.getMapper(TyreMapper.class);
    @InjectMocks
    private TyreController tyreController;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(tyreController)
                .defaultRequest(get("/")
                        .accept(MediaType.APPLICATION_JSON))
                .alwaysExpect(status().isOk())
                .alwaysExpect(content()
                        .contentType("application/json"))
                .build();
    }

    private List<Tyre> getTyres() {
        Tyre tyre1 = new Tyre(1L, "Michelin", "Summer");
        Tyre tyre2 = new Tyre(2L, "Bridgestone", "Winter");
        return List.of(tyre1, tyre2);
    }

    @Test
    void createTyre() throws Exception {
        Tyre newTyre = new Tyre("Michelin", "Summer");
        when(tyreService.create(any(Tyre.class))).thenReturn(newTyre);
        mockMvc.perform(post("/api/tyres")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(newTyre))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Michelin"))
                .andExpect(jsonPath("$.season").value("Summer"));
        verify(tyreService).create(any(Tyre.class));
    }

    @Test
    void readOneTyre() throws Exception {
        when(this.tyreService.readById(1L)).thenReturn(getTyres().get(0));
        mockMvc.perform(get("/api/tyres/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Michelin"))
                .andExpect(jsonPath("$.season").value("Summer"));
        verify(tyreMapper).toTyreDto(any(Tyre.class));
    }

    @Test
    void readAllTyres() throws Exception {
        when(this.tyreService.readAll()).thenReturn(getTyres());
        mockMvc.perform(get("/api/tyres"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

    }

    @Test
    void updateTyre() throws Exception {
        Tyre newTyre = new Tyre(1L, "Bridgestone", "Summer");
        when(tyreService.update(any(Long.class), any(Tyre.class))).thenReturn(newTyre);
        mockMvc.perform(put("/api/tyres/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(newTyre))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Bridgestone"))
                .andExpect(jsonPath("$.season").value("Summer"));
        verify(tyreService).update(any(Long.class), any(Tyre.class));
    }

    @Test
    public void deleteTyre() throws Exception {
        doNothing().when(tyreService).deleteById(any(Long.class));
        mockMvc.perform(delete("/api/tyres/{id}", 1))
                .andExpect(status().isOk());
        verify(tyreService).deleteById(any(Long.class));
    }
}
