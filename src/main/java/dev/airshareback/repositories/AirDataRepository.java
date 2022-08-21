package dev.airshareback.repositories;

import dev.airshareback.entities.AirData;
import dev.airshareback.entities.City;
import dev.airshareback.entities.Departement;
import dev.airshareback.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirDataRepository extends JpaRepository<AirData, Integer> {
    List<AirData> findByCityOrderByDatetimeDesc(City city);

    List<AirData> findByCity_Departement(Departement city_departement);

    List<AirData> findByCity_Departement_Region(Region city_departement_region);
}
