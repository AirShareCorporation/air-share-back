package dev.airshareback.controllers;

import dev.airshareback.entities.MeteoData;
import dev.airshareback.services.MeteoDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;

public class MeteoDataController {

    private MeteoDataService meteoDataService;

    @GetMapping("meteo-record/{city}")
    public List<MeteoData> getRecord(@PathVariable String city) {
        return meteoDataService.getRecord(city).stream().toList();
    }

    @GetMapping("meteo-today/{city}")
    public MeteoData getMeteoToday(@PathVariable String city) throws IOException {
        return meteoDataService.getMeteoToday(city);
    }


}
