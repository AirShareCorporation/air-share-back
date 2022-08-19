package dev.airshareback.repositories;

import dev.airshareback.entities.CensusData;
import dev.airshareback.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CensusDataRepository extends JpaRepository<CensusData, Integer> {
    public CensusData findByCity(City city);
}
