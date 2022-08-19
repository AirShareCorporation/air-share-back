package dev.airshareback.services;

import dev.airshareback.entities.AirData;
import dev.airshareback.entities.Response;
import dev.airshareback.repositories.ResponseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponseService {

    private ResponseRepository responseRepository;

    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    public List<Response> list() {
        return responseRepository.findAll();
    }

    public Optional<Response> get(Long id) {
        return responseRepository.findById(id);
    }

}
