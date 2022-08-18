package dev.airshareback.services;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.airshareback.entities.AirData;
import dev.airshareback.entities.City;
import dev.airshareback.repositories.AirDataRepository;
import dev.airshareback.repositories.CityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class AirDataService {
    private AirDataRepository airDataRepository;
    private CityRepository cityRepository;

    public AirDataService(AirDataRepository airDataRepository, CityRepository cityRepository) {
        this.airDataRepository = airDataRepository;
        this.cityRepository = cityRepository;
    }

    public List<AirData> list() {
        return airDataRepository.findAll();
    }

    public List<AirData> getRecord(String name) {
        Optional<City> c = cityRepository.findByName(name);
        return airDataRepository.findByCityOrderByDatetimeDesc(c.get().getId());
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
        airData.setH(json.get("data").get("iaqi").get("h").get("v").asDouble());
        airData.setNo2(json.get("data").get("iaqi").get("no2").get("v").asDouble());
        airData.setO3(json.get("data").get("iaqi").get("o3").get("v").asDouble());
        airData.setP(json.get("data").get("iaqi").get("p").get("v").asDouble());
        airData.setPm10(json.get("data").get("iaqi").get("pm10").get("v").asDouble());
        airData.setPm25(json.get("data").get("iaqi").get("pm25").get("v").asDouble());
        airData.setSo2(json.get("data").get("iaqi").get("so2").get("v").asDouble());
        airData.setT(json.get("data").get("iaqi").get("t").get("v").asDouble());
        airData.setW(json.get("data").get("iaqi").get("w").get("v").asDouble());

        airData.setDate(LocalDateTime.now());

        airData.setLatitude(json.get("data").get("city").get("geo").get(0).asDouble());
        airData.setLongitude(json.get("data").get("city").get("geo").get(1).asDouble());

        Optional<City> c = cityRepository.findBySlug(name);
        airData.setCity(c.get());

        return airDataRepository.save(airData);
    }
}
