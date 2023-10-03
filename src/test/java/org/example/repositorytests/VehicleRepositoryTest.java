package org.example.repositorytests;

import org.example.AbstractIntegrationTest;
import org.example.configuration.Config;
import org.example.model.entity.Person;
import org.example.model.entity.Tyre;
import org.example.model.entity.Vehicle;
import org.example.model.repository.PersonRepository;
import org.example.model.repository.TyreRepository;
import org.example.model.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringJUnitConfig(classes = {Config.class, VehicleRepository.class, TyreRepository.class, PersonRepository.class})
public class VehicleRepositoryTest extends AbstractIntegrationTest {

    private final PersonRepository personRepository;
    private final VehicleRepository vehicleRepository;
    private final TyreRepository tyreRepository;

    @Autowired
    public VehicleRepositoryTest(PersonRepository personRepository,
                                 VehicleRepository vehicleRepository, TyreRepository tyreRepository) {
        this.personRepository = personRepository;
        this.vehicleRepository = vehicleRepository;
        this.tyreRepository = tyreRepository;
    }

    @Test
    @Sql("/db.sql")
    public void findByIdWithTyres() {
        Person person = new Person();
        person.setFirstName("Ivan");
        person.setLastName("Petrov");
        person = personRepository.save(person);
        Tyre tyre1 = new Tyre();
        tyre1.setName("Bridgestone");
        tyre1.setSeason("Summer");
        tyre1 = tyreRepository.save(tyre1);
        Tyre tyre2 = new Tyre();
        tyre2.setName("Michelin");
        tyre2.setSeason("Winter");
        tyre2 = tyreRepository.save(tyre2);
        Vehicle vehicle = new Vehicle();
        vehicle.setModel("BMW");
        vehicle.setType("Suv");
        vehicle.setPerson(person);
        vehicle.setTyres(List.of(tyre1, tyre2));
        vehicle = vehicleRepository.save(vehicle);

        Vehicle currentVehicle = vehicleRepository.findByIdWithTyres(vehicle.getId()).orElseThrow();
        List<String> tyreSeasons = currentVehicle.getTyres().stream().map(Tyre::getSeason).collect(Collectors.toList());

        assertEquals(2, currentVehicle.getTyres().size());
        assertTrue(tyreSeasons.contains("Summer"));
        assertTrue(tyreSeasons.contains("Winter"));

        vehicleRepository.delete(vehicle);
        tyreRepository.delete(tyre1);
        tyreRepository.delete(tyre2);
        personRepository.delete(person);
    }
}
