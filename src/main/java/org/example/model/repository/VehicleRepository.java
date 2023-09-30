package org.example.model.repository;

import org.example.model.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("vehicleRepository")
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v LEFT JOIN FETCH v.person LEFT JOIN FETCH v.tyres WHERE v.id = ?1")
    Optional<Vehicle> findByIdWithTyres(Long id);
}
