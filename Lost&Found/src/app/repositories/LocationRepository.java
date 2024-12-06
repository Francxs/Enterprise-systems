package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import app.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
    // Updated method to match entity field name
    Optional<Location> findByLocationID(int locationID);
}