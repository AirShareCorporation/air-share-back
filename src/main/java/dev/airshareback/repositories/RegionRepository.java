package dev.airshareback.repositories;

import dev.airshareback.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Integer> {
    Optional<Region> findBySlug(String slug);
}
