package org.example.model.dto;

import org.example.model.entity.Tyre;

import java.util.List;

public class VehicleDto {

    private long id;
    private String type;
    private String model;
    private long personId;
    private List<Tyre> tyres;

    public VehicleDto() {
    }

    public VehicleDto(long id, String type, String model, long personId,List<Tyre> tyres) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.personId = personId;
        this.tyres = tyres;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getPerson() {
        return personId;
    }

    public void setPerson(long personId) {
        this.personId = personId;
    }

    public List<Tyre> getTyres() {
        return tyres;
    }

    public void setTyres(List<Tyre> tyres) {
        this.tyres = tyres;
    }

}