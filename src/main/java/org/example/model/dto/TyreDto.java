package org.example.model.dto;

import org.example.model.entity.Vehicle;

import java.util.List;

public class TyreDto {

    long id;
    private String name;
    private String season;
    private List<Vehicle> vehicles;

    public TyreDto() {
    }

    public TyreDto(long id, String name, String season, List<Vehicle> vehicles) {
        this.id = id;
        this.name = name;
        this.season = season;
        this.vehicles = vehicles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}