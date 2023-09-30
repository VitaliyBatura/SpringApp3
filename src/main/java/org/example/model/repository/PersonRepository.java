package org.example.model.repository;

import org.example.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("personRepository")
public interface PersonRepository extends JpaRepository<Person, Long> {

}
