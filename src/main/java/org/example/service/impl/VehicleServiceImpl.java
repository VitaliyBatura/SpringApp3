package org.example.service.impl;

import org.example.model.entity.Vehicle;
import org.example.model.repository.VehicleRepository;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    @Transactional
    public Vehicle create(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    @Transactional
    public Vehicle readById(Long id) {
        return vehicleRepository.findByIdWithTyres(id).orElseThrow();
    }

    @Override
    @Transactional
    public List<Vehicle> readAll() {
        return new ArrayList<>((Collection) vehicleRepository.findAll());
    }

    @Override
    @Transactional
    public Vehicle update(Long id, Vehicle vehicle) {
        vehicle.setId(id);
        return vehicleRepository.save(vehicle);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        vehicleRepository.deleteById(id);

    }
}