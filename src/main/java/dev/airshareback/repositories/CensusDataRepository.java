package dev.airshareback.repositories;

import dev.airshareback.entities.CensusData;
import dev.airshareback.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CensusDataRepository extends JpaRepository<CensusData, Integer> {
    CensusData findByCity(City city);
}
