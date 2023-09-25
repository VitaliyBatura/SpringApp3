package org.example.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tyre")
public class Tyre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "season")
    private String season;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "vehicle_tyre",
            joinColumns = @JoinColumn(name = "tyre_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private List<Vehicle> vehicles;

    public Tyre() {
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

    public void addVehicleToTyre(Vehicle vehicle) {
        if(vehicles == null) {
            vehicles =new ArrayList<>();
        }
        vehicles.add(vehicle);
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

    @Override
    public String toString() {
        return "Tyre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}
