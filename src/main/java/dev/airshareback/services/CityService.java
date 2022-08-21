package dev.airshareback.services;

import dev.airshareback.entities.City;
import dev.airshareback.repositories.CityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCities() {
        return cityRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
