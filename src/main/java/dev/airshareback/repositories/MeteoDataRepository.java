package dev.airshareback.repositories;

import dev.airshareback.entities.MeteoData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeteoDataRepository extends JpaRepository<MeteoData, Integer> {
    public List<MeteoData> findByCityOrderByDateTimeDesc(Long id);
}
