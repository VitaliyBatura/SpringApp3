package org.example.service;

import org.example.model.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    Vehicle create(Vehicle vehicle);

    Vehicle readById(Long id);

    List<Vehicle> readAll();

    Vehicle update(Long id, Vehicle vehicle);

    void deleteById(Long id);
}
