package dev.airshareback.repositories;

import dev.airshareback.entities.AirData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirDataRepository extends JpaRepository<AirData, Integer> {
}
