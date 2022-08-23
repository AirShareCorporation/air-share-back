package dev.airshareback.repositories;

import dev.airshareback.entities.Status;
import dev.airshareback.entities.Topic;
import dev.airshareback.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    Optional<Status> findByName(String name);
    Optional<Status> findById(Long id);
}
