package dev.airshareback.repositories;

import dev.airshareback.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Integer> {
    public Optional<Status> findByName(String name);
}
