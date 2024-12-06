package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdNumber(int idNumber);
}
