package org.example.controller;

import org.example.model.dto.VehicleDto;
import org.example.model.dto.VehicleShortDto;
import org.example.model.entity.Vehicle;
import org.example.model.mapper.VehicleMapper;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class VehicleController {

    private VehicleService vehicleService;
    private VehicleMapper vehicleMapper;

    @Autowired
    public VehicleController(VehicleService vehicleService, VehicleMapper vehicleMapper) {
        this.vehicleService = vehicleService;
        this.vehicleMapper = vehicleMapper;
    }

    @PostMapping("/vehicles")
    public VehicleDto createVehicle(@RequestBody VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.toVehicle(vehicleDto);
        return vehicleMapper.toVehicleDto(vehicleService.create(vehicle));
    }

    @GetMapping("/vehicles/{id}")
    public VehicleDto readOneVehicle(@PathVariable Long id) {
        return  vehicleMapper.toVehicleDto(vehicleService.readById(id));
    }

    @GetMapping("/vehicles")
    public List<VehicleShortDto> readAllVehicles() {
        return vehicleMapper.toVehicleDtoList(vehicleService.readAll());
    }

    @PutMapping("/vehicles/{id}")
    public VehicleDto updateVehicle(@PathVariable Long id, @RequestBody VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleMapper.toVehicle(vehicleDto);
        return vehicleMapper.toVehicleDto(vehicleService.update(id, vehicle));
    }

    @DeleteMapping("/vehicles/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteById(id);
        return "Vehicle with ID = " + id + " was deleted";
    }

}
