package dev.airshareback.services;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.airshareback.entities.CensusData;
import dev.airshareback.entities.City;
import dev.airshareback.entities.Departement;
import dev.airshareback.repositories.CensusDataRepository;
import dev.airshareback.repositories.CityRepository;
import dev.airshareback.repositories.DepartementRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class CensusDataService {
    private CensusDataRepository censusDataRepository;
    private CityRepository cityRepository;
    private DepartementRepository departementRepository;


    public CensusDataService(CensusDataRepository censusDataRepository, CityRepository cityRepository, DepartementRepository departementRepository) {
        this.censusDataRepository = censusDataRepository;
        this.cityRepository = cityRepository;
        this.departementRepository = departementRepository;
    }

    public CensusData getCensus(String city) throws IOException {
        Optional<City> c = cityRepository.findBySlug(city);
        WebClient client = WebClient.builder()
            .baseUrl(String.format("https://geo.api.gouv.fr/communes?nom=%s", city))
            .build();
        String data = client.get()
            .uri(UriBuilder::build)
            .retrieve()
            .bodyToMono(String.class)
            .block();

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(data);
        JsonNode json = mapper.readTree(parser);

        if (c.isEmpty()) {
            City newCity = new City();

            newCity.setDepartementCode(json.get(0).get("codeDepartement").asText());
            newCity.setInseeCode(json.get(0).get("code").asText());
            newCity.setName(json.get(0).get("nom").asText());
            newCity.setSlug(json.get(0).get("nom").asText().toLowerCase());
            Optional<Departement> dept = departementRepository.findByCode(json.get(0).get("codeDepartement").asText());
            newCity.setDepartement(dept.get());
            cityRepository.save(newCity);
        }
        CensusData censusData = new CensusData();

        censusData.setDataCensus(json.get(0).get("population").asInt());
        censusData.setDate(LocalDate.now());
        censusData.setCity(cityRepository.findBySlug(city).get());

        return censusDataRepository.save(censusData);
    }
}
