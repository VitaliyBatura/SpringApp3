package org.example.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tyre")
public class Tyre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "season")
    private String season;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tyres")
    private List<Vehicle> vehicles = new ArrayList<>();

    public Tyre() {
    }

    public Tyre(Long id, String name, String season) {
        this.id = id;
        this.name = name;
        this.season = season;
    }

    public Tyre(String name, String season) {
        this.name = name;
        this.season = season;
    }

    public Tyre(String name, String season, List<Vehicle> vehicles) {
        this.name = name;
        this.season = season;
        this.vehicles = vehicles;
    }

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
}
