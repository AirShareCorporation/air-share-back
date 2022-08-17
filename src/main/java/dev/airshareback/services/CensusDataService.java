package dev.airshareback.services;

import dev.airshareback.entities.CensusData;
import dev.airshareback.repositories.CensusDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CensusDataService {
    private CensusDataRepository censusDataRepository;

    public CensusDataService(CensusDataRepository censusDataRepository) {
        this.censusDataRepository = censusDataRepository;
    }

    public List<CensusData> list() {
        return censusDataRepository.findAll();
    }

    public Optional<CensusData> get(int id) {
        return censusDataRepository.findById(id);
    }
}
