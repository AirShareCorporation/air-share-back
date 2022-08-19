package dev.airshareback.repositories;

import dev.airshareback.entities.AirData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirDataRepository extends JpaRepository<AirData, Integer> {
    public List<AirData> findByCityOrderByDatetimeDesc(Long cityId);
}
