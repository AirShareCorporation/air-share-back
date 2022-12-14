package dev.airshareback.controllers;

import dev.airshareback.entities.MeteoData;
import dev.airshareback.services.MeteoDataService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/")
public class MeteoDataController {
    private MeteoDataService meteoDataService;

    public MeteoDataController(MeteoDataService meteoDataService) {
        this.meteoDataService = meteoDataService;
    }

    @GetMapping("meteo-now/{city}")
    public MeteoData getMeteoNow(@PathVariable String city) throws IOException {
        return meteoDataService.getMeteoNow(city);
    }

    @GetMapping("meteo-record/city/{city}")
    public List<MeteoData> getMeteoRecord(@PathVariable String city) {
        return meteoDataService.getMeteoRecord(city);
    }


    @GetMapping("meteo-record/department/{department}")
    public List<MeteoData> getDepartmentAirRecord(@PathVariable String department) {
        return meteoDataService.getDepartmentRecord(department);
    }

    @GetMapping("meteo-record/region/{region}")
    public List<MeteoData> getRegionAirRecord(@PathVariable String region) {
        return meteoDataService.getRegionRecord(region);
    }

}
