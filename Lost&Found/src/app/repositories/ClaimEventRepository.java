package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import app.entities.ClaimEvent;

public interface ClaimEventRepository extends JpaRepository<ClaimEvent, Long> {
    Optional<ClaimEvent> findByClaimID(int claimID); // Corrected method name
}