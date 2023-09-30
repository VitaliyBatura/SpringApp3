package org.example.model.dto;

import java.util.List;

public class TyreDto {

    Long id;
    private String name;
    private String season;
    //private List<VehicleDto> vehicles;

    public TyreDto() {
    }

//    public TyreDto(Long id, String name, String season, List<VehicleDto> vehiclesDto) {
//        this.id = id;
//        this.name = name;
//        this.season = season;
//        this.vehicles = vehiclesDto;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

//    public List<VehicleDto> getVehicles() {
//        return vehicles;
//    }
//
//    public void setVehicles(List<VehicleDto> vehicles) {
//        this.vehicles = vehicles;
//    }
}