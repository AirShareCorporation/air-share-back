package dev.airshareback.repositories;

import dev.airshareback.entities.ModerationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ModerationStatusRepository extends JpaRepository<ModerationStatus, Integer> {
    public Optional<ModerationStatus> findByName(String name);
}
