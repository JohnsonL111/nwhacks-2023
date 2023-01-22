package com.J3M.nwhacks.repository;

import com.J3M.nwhacks.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByIdentifierName(String identifierName);
}
