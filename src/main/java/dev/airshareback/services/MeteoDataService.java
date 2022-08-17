package dev.airshareback.services;

import dev.airshareback.entities.MeteoData;
import dev.airshareback.repositories.MeteoDataRepository;

import java.util.List;
import java.util.Optional;

public class MeteoDataService {
    private MeteoDataRepository meteoDataRepository;

    public MeteoDataService(MeteoDataRepository meteoDataRepository) {
        this.meteoDataRepository = meteoDataRepository;
    }

    public List<MeteoData> list() {
        return meteoDataRepository.findAll();
    }

    public Optional<MeteoData> get(int id) {
        return meteoDataRepository.findById(id);
    }
}
