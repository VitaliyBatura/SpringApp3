package org.example.controllertests;

import org.example.controller.VehicleController;
import org.example.model.dto.VehicleDto;
import org.example.model.entity.Vehicle;
import org.example.model.mapper.VehicleMapper;
import org.example.service.VehicleService;

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
public class VehicleControllerTest {

    @Mock
    private VehicleService vehicleService;
    @Spy
    private VehicleMapper vehicleMapper;
    @InjectMocks
    private VehicleController vehicleController;

    @Test
    public void createVehicle() {
        when(vehicleService.create(any(Vehicle.class))).thenReturn(new Vehicle());
        vehicleController.createVehicle(new VehicleDto());
        verify(vehicleMapper).toVehicle(any(VehicleDto.class));
        verify(vehicleService).create(any(Vehicle.class));
        verify(vehicleMapper).toVehicleDto(any(Vehicle.class));
    }

    @Test
    public void readOneVehicle() {
        when(vehicleService.readById(any(Long.class))).thenReturn(new Vehicle());
        vehicleController.readOneVehicle(1L);
        verify(vehicleService).readById(1L);
        verify(vehicleMapper).toVehicleDto(any(Vehicle.class));
    }

    @Test
    public void readAllVehicles() {
        when(vehicleService.readAll()).thenReturn(Collections.emptyList());
        vehicleController.readAllVehicles();
        verify(vehicleService).readAll();
        verify(vehicleMapper).toVehicleList(any());
    }

    @Test
    public void updateVehicle() {
        when(vehicleService.update(any(Long.class), any(Vehicle.class))).thenReturn(new Vehicle());
        vehicleController.updateVehicle(1L, new VehicleDto());
        verify(vehicleService).update(any(Long.class), any(Vehicle.class));
    }

    @Test
    public void deleteVehicle() {
        doNothing().when(vehicleService).deleteById(any(Long.class));
        vehicleController.deleteVehicle(1L);
        verify(vehicleService).deleteById(any(Long.class));
    }
}
