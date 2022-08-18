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
import org.springframework.web.util.UriBuilder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MeteoDataService {
    private MeteoDataRepository meteoDataRepository;
    private CityRepository cityRepository;

    public MeteoDataService(MeteoDataRepository meteoDataRepository, CityRepository cityRepository) {
        this.meteoDataRepository = meteoDataRepository;
        this.cityRepository = cityRepository;
    }

    public List<MeteoData> getMeteoRecord(String name) {
        Optional<City> c = cityRepository.findByName(name);
        return meteoDataRepository.findByCityOrderByDateTimeDesc(c.get().getId());
    }

    public MeteoData getMeteoNow(String city) throws IOException {
        City c = cityRepository.findBySlug(city).get();
        String insee = c.getInseeCode();

        WebClient client = WebClient.builder().baseUrl(String.format("https://api.meteo-concept.com/api/forecast/daily?insee=%s", insee)).build();
        String data = client.get()
            .uri(UriBuilder::build)
            .headers(h -> h.setBearerAuth("8e60ef9fa49f04b6ca49ac2cae77a277f9a92221cd85518ce7f0d5cedfce32de"))
            .retrieve()
            .bodyToMono(String.class)
            .block();

        ObjectMapper mapper = new ObjectMapper();
        JsonFactory factory = mapper.getFactory();
        JsonParser parser = factory.createParser(data);
        JsonNode json = mapper.readTree(parser);

        MeteoData meteoData = new MeteoData();

        meteoData.setDateTime(LocalDateTime.now());

        meteoData.setLatitude(json.get("forecast").get(0).get("latitude").asDouble());
        meteoData.setLongitude(json.get("forecast").get(0).get("longitude").asDouble());
        meteoData.setSunHours(json.get("forecast").get(0).get("sun_hours").asInt());
        meteoData.setTmax(json.get("forecast").get(0).get("tmax").asInt());
        meteoData.setTmin(json.get("forecast").get(0).get("tmin").asInt());
        meteoData.setWeather(json.get("forecast").get(0).get("weather").asInt());
        meteoData.setCity(c);

        return meteoDataRepository.save(meteoData);
    }
}
