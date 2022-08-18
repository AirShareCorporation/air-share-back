package dev.airshareback.repositories;

import dev.airshareback.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {
    public Optional<City> findByName(String name);
}
