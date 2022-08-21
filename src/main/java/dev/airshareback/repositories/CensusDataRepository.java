package dev.airshareback.repositories;

import dev.airshareback.entities.CensusData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CensusDataRepository extends JpaRepository<CensusData, Integer> {
}
