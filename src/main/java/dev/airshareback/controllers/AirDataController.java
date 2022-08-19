package dev.airshareback.controllers;

import dev.airshareback.entities.AirData;
import dev.airshareback.services.AirDataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/")
public class AirDataController {
    private AirDataService airDataService;

    public AirDataController(AirDataService airDataService) {
        this.airDataService = airDataService;
    }

    @GetMapping("air-record/{city}")
    public List<AirData> getAirRecord(@PathVariable String city) {
        return airDataService.getRecord(city);
    }

    @GetMapping("air-now/{city}")
    public AirData getAirToday(@PathVariable String city) throws IOException {
        return airDataService.getAirNow(city);
    }
}
