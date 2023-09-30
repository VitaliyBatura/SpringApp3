package org.example.model.dto;

import java.util.List;

public class VehicleDto {

    private Long id;
    private String type;
    private String model;
    private PersonDto person;

 //   private Long personId;
    private List<TyreDto> tyres;

    public VehicleDto() {
    }

    public VehicleDto(Long id, String type, String model, PersonDto personDto, List<TyreDto> tyresDto) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.person = personDto;
        this.tyres = tyresDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public List<TyreDto> getTyres() {
        return tyres;
    }

    public void setTyres(List<TyreDto> tyres) {
        this.tyres = tyres;
    }

}