package org.example.servicetests;

import org.example.model.entity.Person;
import org.example.model.entity.Vehicle;
import org.example.model.repository.VehicleRepository;
import org.example.service.impl.VehicleServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class VehicleServiceImplTest {
    @Mock
    private VehicleRepository vehicleRepository;
    @InjectMocks
    private VehicleServiceImpl vehicleService;

    @Test
    public void create() {
        Person person = new Person("Stepan", "Sokolov");
        Vehicle vehicle = new Vehicle("Car", "Lada", person);
        when(vehicleRepository.save(vehicle)).thenReturn(new Vehicle("Car", "Lada", person));
        vehicleService.create(vehicle);
        verify(vehicleRepository).save(vehicle);
    }

    @Test
    public void readById() {
        when(vehicleRepository.findByIdWithTyres(anyLong())).thenReturn(Optional.of(new Vehicle()));
        vehicleService.readById(1L);
        verify(vehicleRepository).findByIdWithTyres(1L);
    }

    @Test
    public void readAll() {
        when(vehicleRepository.findAll()).thenReturn(Collections.emptyList());
        vehicleService.readAll();
        verify(vehicleRepository).findAll();
    }

    @Test
    public void update() {
        Person person = new Person("Stepan", "Sokolov");
        Vehicle vehicle = new Vehicle("Car", "Lada", person);
        when(vehicleRepository.save(vehicle)).thenReturn(new Vehicle("Car", "Lada", person));
        vehicleService.update(1L, vehicle);
        verify(vehicleRepository).save(vehicle);
    }

    @Test
    public void deleteById() {
        doNothing().when(vehicleRepository).deleteById(anyLong());
        vehicleService.deleteById(1L);
        verify(vehicleRepository).deleteById(1L);
    }
}
