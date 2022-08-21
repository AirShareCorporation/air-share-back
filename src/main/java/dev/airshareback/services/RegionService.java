package dev.airshareback.services;

import dev.airshareback.entities.Region;
import dev.airshareback.repositories.RegionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {
    private RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getRegions() {
        return regionRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
