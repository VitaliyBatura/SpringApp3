package org.example.model.repository;

import org.example.model.entity.Tyre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tyreRepository")
public interface TyreRepository extends JpaRepository<Tyre, Long> {
}
