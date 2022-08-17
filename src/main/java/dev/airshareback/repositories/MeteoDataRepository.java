package dev.airshareback.repositories;

import dev.airshareback.entities.MeteoData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeteoDataRepository extends JpaRepository<MeteoData, Integer> {
}
