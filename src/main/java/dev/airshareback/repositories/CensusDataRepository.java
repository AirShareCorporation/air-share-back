package dev.airshareback.repositories;

import dev.airshareback.entities.CensusData;
import dev.airshareback.entities.City;
import dev.airshareback.entities.Departement;
import dev.airshareback.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CensusDataRepository extends JpaRepository<CensusData, Integer> {
    public CensusData findByCity(City city);

    List<CensusData> findByCity_Departement(Departement city_departement);

    List<CensusData> findByCity_Departement_Region(Region city_departement_region);
}
