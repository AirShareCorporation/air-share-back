package dev.airshareback.controllers;

import dev.airshareback.entities.Region;
import dev.airshareback.services.RegionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/")
public class RegionController {
    private RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("regions")
    public List<Region> getDepartments() {
        return regionService.getRegions();
    }
}
