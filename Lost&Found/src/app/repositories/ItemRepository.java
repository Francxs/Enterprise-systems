package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import app.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByItemID(int itemID); // Corrected method name
}