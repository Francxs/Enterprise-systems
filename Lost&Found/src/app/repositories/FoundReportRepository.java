package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import app.entities.FoundReport;

public interface FoundReportRepository extends JpaRepository<FoundReport, Long> {
    Optional<FoundReport> findByFoundID(int foundID); // Corrected method name
}

