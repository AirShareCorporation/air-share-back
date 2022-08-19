package dev.airshareback.services;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.airshareback.entities.CensusData;
import dev.airshareback.entities.City;
import dev.airshareback.repositories.CensusDataRepository;
import dev.airshareback.repositories.CityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CensusDataService {
    private CensusDataRepository censusDataRepository;
    private CityRepository cityRepository;

    public CensusDataService(CensusDataRepository censusDataRepository, CityRepository cityRepository) {
        this.censusDataRepository = censusDataRepository;
        this.cityRepository = cityRepository;
    }

    public CensusData getCensus(String city) throws IOException {
        City c = cityRepository.findBySlug(city).get();
        String insee = c.getInseeCode();

        WebClient client = WebClient.builder()
            .baseUrl(String.format("https://api.insee.fr/donnees-locales/V0.1/donnees/geo-SEXE-AGE15_15_90@GEO2021RP2018/COM-%s.all.all", insee))
            .defaultHeader("Accept", "application/json")
            .build();
        String data = client.get()
            .uri(UriBuilder::build)
            .headers(h -> h.setBearerAuth("97b049c8-37f5-3a75-bf08-43273a413cfa"))
            .retrieve()
            .bodyToMono(String.class)
            .block();

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(data);
        JsonNode json = mapper.readTree(parser);

        CensusData censusData = new CensusData();

        censusData.setDataCensus(json.get("Cellule").get(0).get("Valeur").asInt());
        censusData.setDate(LocalDate.now());
        censusData.setCity(c);

        return censusDataRepository.save(censusData);
    }
}
