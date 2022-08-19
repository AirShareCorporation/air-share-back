package dev.airshareback.controllers;

import dev.airshareback.entities.CensusData;
import dev.airshareback.entities.MeteoData;
import dev.airshareback.services.CensusDataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/")
public class CensusDataController {
    private CensusDataService censusDataService;

    public CensusDataController(CensusDataService censusDataService) {
        this.censusDataService = censusDataService;
    }

    @GetMapping("census/{city}")
    public CensusData getCensus(@PathVariable String city) throws IOException {
        return censusDataService.getCensus(city);
    }
}
