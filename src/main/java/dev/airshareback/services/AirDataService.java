package dev.airshareback.services;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.airshareback.entities.AirData;
import dev.airshareback.entities.City;
import dev.airshareback.entities.Departement;
import dev.airshareback.entities.Region;
import dev.airshareback.repositories.AirDataRepository;
import dev.airshareback.repositories.CityRepository;
import dev.airshareback.repositories.DepartementRepository;
import dev.airshareback.repositories.RegionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AirDataService {
    private AirDataRepository airDataRepository;
    private CityRepository cityRepository;

    private DepartementRepository departementRepository;

    private RegionRepository regionRepository;

    public AirDataService(AirDataRepository airDataRepository, CityRepository cityRepository, DepartementRepository departementRepository, RegionRepository regionRepository) {
        this.airDataRepository = airDataRepository;
        this.cityRepository = cityRepository;
        this.departementRepository = departementRepository;
        this.regionRepository = regionRepository;
    }

    public List<AirData> list() {
        return airDataRepository.findAll();
    }

    public List<AirData> getCityRecord(String name) {
        Optional<City> c = cityRepository.findBySlug(name);
        return airDataRepository.findByCityOrderByDatetimeDesc(c.get());
    }

    public List<AirData> getDepartmentRecord(String name) {
        Optional<Departement> dept = departementRepository.findBySlug(name);
        return airDataRepository.findByCity_DepartementOrderByDatetimeDesc(dept.get());
    }

    public List<AirData> getRegionRecord(String name) {
        Optional<Region> region = regionRepository.findBySlug(name);
        return airDataRepository.findByCity_Departement_RegionOrderByDatetimeDesc(region.get());
    }

    public AirData getAirNow(String name) throws IOException {
        WebClient client = WebClient.builder().baseUrl(String.format("https://api.waqi.info/feed/%s", name))
            .build();
        String data = client.get().uri(uriBuilder -> uriBuilder
                .queryParam("token", "16d2a1179073e4d1fa5466876faa04c04ef51f71")
                .build())
            .retrieve()
            .bodyToMono(String.class)
            .block();

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(data);
        JsonNode json = mapper.readTree(parser);

        AirData airData = new AirData();

        if (json.get("data").get("iaqi").get("co") != null)
            airData.setCo(json.get("data").get("iaqi").get("co").get("v").asDouble());
        if (json.get("data").get("iaqi").get("h") != null)
            airData.setH(json.get("data").get("iaqi").get("h").get("v").asDouble());
        if (json.get("data").get("iaqi").get("no2") != null)
            airData.setNo2(json.get("data").get("iaqi").get("no2").get("v").asDouble());
        if (json.get("data").get("iaqi").get("o3") != null)
            airData.setO3(json.get("data").get("iaqi").get("o3").get("v").asDouble());
        if (json.get("data").get("iaqi").get("p") != null)
            airData.setP(json.get("data").get("iaqi").get("p").get("v").asDouble());
        if (json.get("data").get("iaqi").get("pm10") != null)
            airData.setPm10(json.get("data").get("iaqi").get("pm10").get("v").asDouble());
        if (json.get("data").get("iaqi").get("pm25") != null)
            airData.setPm25(json.get("data").get("iaqi").get("pm25").get("v").asDouble());
        if (json.get("data").get("iaqi").get("so2") != null)
            airData.setSo2(json.get("data").get("iaqi").get("so2").get("v").asDouble());
        if (json.get("data").get("iaqi").get("t") != null)
            airData.setT(json.get("data").get("iaqi").get("t").get("v").asDouble());
        if (json.get("data").get("iaqi").get("w") != null)
            airData.setW(json.get("data").get("iaqi").get("w").get("v").asDouble());

        airData.setDate(LocalDateTime.now());

        airData.setLatitude(json.get("data").get("city").get("geo").get(0).asDouble());
        airData.setLongitude(json.get("data").get("city").get("geo").get(1).asDouble());

        Optional<City> c = cityRepository.findBySlug(name);
        airData.setCity(c.get());

        return airDataRepository.save(airData);
    }
}
