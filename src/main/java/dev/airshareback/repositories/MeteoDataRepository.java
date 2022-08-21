package dev.airshareback.repositories;

import dev.airshareback.entities.City;
import dev.airshareback.entities.Departement;
import dev.airshareback.entities.MeteoData;
import dev.airshareback.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeteoDataRepository extends JpaRepository<MeteoData, Integer> {
    List<MeteoData> findByCityOrderByDateTimeDesc(City city);

    List<MeteoData> findByCity_DepartementOrderByDateTimeDesc(Departement city_departement);

    List<MeteoData> findByCity_Departement_RegionOrderByDateTimeDesc(Region city_departement_region);

}
