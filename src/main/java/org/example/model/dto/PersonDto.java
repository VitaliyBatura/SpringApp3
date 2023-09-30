package org.example.model.dto;

import org.example.model.entity.Vehicle;

import java.util.List;

public class PersonDto {

    Long id;
    private String firstName;
    private String lastName;
   // private List<Vehicle> vehicles;

    public PersonDto() {
    }

    public PersonDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    public PersonDto(Long id, String firstName, String lastName, List<Vehicle> vehicles) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.vehicles = vehicles;
//    }

    public PersonDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    public PersonDto(String firstName, String lastName, List<Vehicle> vehicles) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.vehicles = vehicles;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public List<Vehicle> getVehicles() {
//        return vehicles;
//    }
//
//    public void setVehicles(List<Vehicle> vehicles) {
//        this.vehicles = vehicles;
//    }
}