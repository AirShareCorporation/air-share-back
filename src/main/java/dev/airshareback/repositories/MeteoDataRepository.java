package dev.airshareback.repositories;

import dev.airshareback.entities.MeteoData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MeteoDataRepository extends JpaRepository<MeteoData, Integer> {

    Optional<MeteoData> findByCity(String city);
}
