package com.J3M.nwhacks.repository;

import com.J3M.nwhacks.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findPersonByUsername(String username);

    Boolean existsByUsername(String username);
}
