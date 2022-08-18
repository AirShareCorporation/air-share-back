package dev.airshareback.services;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.airshareback.entities.City;
import dev.airshareback.entities.MeteoData;
import dev.airshareback.repositories.CityRepository;
import dev.airshareback.repositories.MeteoDataRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class MeteoDataService {
    private MeteoDataRepository meteoDataRepository;
    private CityRepository cityRepository;

    public MeteoDataService(MeteoDataRepository meteoDataRepository) {
        this.meteoDataRepository = meteoDataRepository;
    }

    public Optional<MeteoData> getRecord(String city) {
        return this.meteoDataRepository.findByCity(city);
    }

    public MeteoData getMeteoToday(String name) throws IOException {

        Optional<City> city = this.cityRepository.findByName(name);

        String inseeCode = city.get().getInseeCode();

        WebClient client = WebClient.builder().baseUrl(String.format("https://api.meteo-concept.com/api/forecast/daily/%s", inseeCode)).build();

        String data = client.get().uri(uriBuilder -> uriBuilder
                    .queryParam("Authorization", "Bearer 8e60ef9fa49f04b6ca49ac2cae77a277f9a92221cd85518ce7f0d5cedfce32de")
                    .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();

        ObjectMapper mapper =new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(data);
        JsonNode json = mapper.readTree(parser);

        MeteoData meteoData = new MeteoData();

        meteoData.setCity(city.get());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        meteoData.setDateTime(LocalDateTime.parse(json.get("update").asText(), formatter));

        meteoData.setWind10m(json.get("forecast").get("wind10m").asInt());
        meteoData.setGust10m(json.get("forecast").get("gust10m").asInt());
        meteoData.setDirwind10m(json.get("forecast").get("dirwind10m").asInt());
        meteoData.setRr10((float) json.get("forecast").get("rr10").asDouble());
        meteoData.setRr1((float) json.get("forecast").get("rr1").asDouble());
        meteoData.setProbarain(json.get("forecast").get("probarain").asInt());
        meteoData.setWeather(json.get("forecast").get("weather").asInt());
        meteoData.setTmin(json.get("forecast").get("tmin").asInt());
        meteoData.setTmax(json.get("forecast").get("tmax").asInt());
        meteoData.setSunHours(json.get("forecast").get("sun_hours").asInt());
        meteoData.setEtp(json.get("forecast").get("etp").asInt());
        meteoData.setProbafrost(json.get("forecast").get("probafrost").asInt());
        meteoData.setProbafog(json.get("forecast").get("probafog").asInt());
        meteoData.setProbawind70(json.get("forecast").get("probawind70").asInt());
        meteoData.setProbawind100(json.get("forecast").get("probawind100").asInt());
        meteoData.setGustx(json.get("forecast").get("gustx").asInt());
        meteoData.setLatitude(json.get("forecast").get("latitude").asDouble());
        meteoData.setLongitude(json.get("forecast").get("longitude").asDouble());

        return meteoDataRepository.save(meteoData);
    }

    public List<MeteoData> list() {
        return meteoDataRepository.findAll();
    }

    public Optional<MeteoData> get(int id) {
        return meteoDataRepository.findById(id);
    }
}
