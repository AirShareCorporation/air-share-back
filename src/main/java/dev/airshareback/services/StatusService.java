package dev.airshareback.services;

import dev.airshareback.entities.Status;
import dev.airshareback.repositories.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    private StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> list() {
        return statusRepository.findAll();
    }

    public Optional<Status> get(int id) {
        return statusRepository.findById(id);
    }

    public Optional<Status> findByName(String name) {
        return statusRepository.findByName(name);
    }
}
