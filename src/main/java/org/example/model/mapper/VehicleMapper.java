package org.example.model.mapper;

import org.example.model.dto.VehicleDto;
import org.example.model.dto.VehicleShortDto;
import org.example.model.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface VehicleMapper {

    VehicleDto toVehicleDto(Vehicle vehicle);

    @Mapping(target = "id", ignore = true)
    Vehicle toVehicle(VehicleDto vehicleDto);

    VehicleShortDto toVehicleShortDto(Vehicle vehicle);

    List<VehicleShortDto> toVehicleDtoList(List<Vehicle> vehicles);
}