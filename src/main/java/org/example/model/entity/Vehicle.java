package org.example.model.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "model")
    private String model;
    @OneToOne(fetch = FetchType.LAZY)//(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToMany//(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "vehicle_tyre",
            joinColumns = @JoinColumn(name = "vehicle_id"),
            inverseJoinColumns = @JoinColumn(name = "tyre_id"))
    private List<Tyre> tyres = new ArrayList<>();

    public Vehicle() {
    }

    public Vehicle(String type, String model, Person person) {
        this.type = type;
        this.model = model;
        this.person = person;
    }

    public Vehicle(String type, String model, Person person, List<Tyre> tyres) {
        this.type = type;
        this.model = model;
        this.person = person;
        this.tyres = tyres;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Tyre> getTyres() {
        return tyres;
    }

    public void setTyres(List<Tyre> tyres) {
        this.tyres = tyres;
    }
}
