package dev.airshareback.services;

import dev.airshareback.entities.AirData;
import dev.airshareback.repositories.AirDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AirDataService {
    private AirDataRepository airDataRepository;

    public AirDataService(AirDataRepository airDataRepository) {
        this.airDataRepository = airDataRepository;
    }

    public List<AirData> list() {
        return airDataRepository.findAll();
    }

    public Optional<AirData> get(int id) {
        return airDataRepository.findById(id);
    }
}
