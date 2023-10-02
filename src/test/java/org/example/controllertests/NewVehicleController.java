package org.example.controllertests;

import org.example.controller.TyreController;
import org.example.controller.VehicleController;
import org.example.model.entity.Tyre;
import org.example.model.entity.Vehicle;
import org.example.model.mapper.TyreMapper;
import org.example.model.mapper.VehicleMapper;
import org.example.service.TyreService;
import org.example.service.VehicleService;
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
public class NewVehicleController {

    @Mock
    private VehicleService vehicleService;
    @Spy
    private VehicleMapper vehicleMapper = Mappers.getMapper(VehicleMapper.class);
    @InjectMocks
    private VehicleController vehicleController;
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(vehicleController)
                .defaultRequest(get("/")
                .accept(MediaType.APPLICATION_JSON))
                .alwaysExpect(status().isOk())
                .alwaysExpect(content()
                .contentType("application/json"))
                .build();
    }

    private List<Vehicle> getVehicles() {
        Vehicle vehicle1 = new Vehicle(1L, "Car", "Lada");
        Vehicle vehicle2 = new Vehicle(2L, "Truck", "KAMAZ");
        return List.of(vehicle1, vehicle2);
    }

    @Test
    void createVehicle() throws Exception {
        Vehicle newVehicle = new Vehicle("Car", "Lada");
        when(vehicleService.create(any(Vehicle.class))).thenReturn(newVehicle);
        mockMvc.perform(post("/api/vehicles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(newVehicle))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("Car"))
                .andExpect(jsonPath("$.model").value("Lada"));
        verify(vehicleService).create(any(Vehicle.class));
    }

    @Test
    void readOneVehicle() throws Exception {
        when(this.vehicleService.readById(1L)).thenReturn(getVehicles().get(0));
        mockMvc.perform(get("/api/vehicles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.type").value("Car"))
                .andExpect(jsonPath("$.model").value("Lada"));
        verify(vehicleMapper).toVehicleDto(any(Vehicle.class));
    }

    @Test
    void readAllVehicles() throws Exception {
        when(this.vehicleService.readAll()).thenReturn(getVehicles());
        mockMvc.perform(get("/api/vehicles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

    }

    @Test
    void updateVehicle() throws Exception {
        Vehicle newVehicle = new Vehicle(1L, "Truck", "Volvo");
        when(vehicleService.update(any(Long.class), any(Vehicle.class))).thenReturn(newVehicle);
        mockMvc.perform(put("/api/vehicles/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(newVehicle))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.type").value("Truck"))
                .andExpect(jsonPath("$.model").value("Volvo"));
        verify(vehicleService).update(any(Long.class), any(Vehicle.class));
    }

    @Test
    public void deleteTyre() throws Exception {
        doNothing().when(vehicleService).deleteById(any(Long.class));
        mockMvc.perform(delete("/api/vehicles/{id}", 1))
                .andExpect(status().isOk());
        verify(vehicleService).deleteById(any(Long.class));
    }
}
