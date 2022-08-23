package dev.airshareback.services;

import dev.airshareback.entities.Status;
import dev.airshareback.entities.User;
import dev.airshareback.repositories.StatusRepository;
import dev.airshareback.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class StatusService {
    private StatusRepository statusRepository;
    private UserRepository userRepository;

    public StatusService(StatusRepository statusRepository, UserRepository userRepository) {
        this.statusRepository = statusRepository;
        this.userRepository = userRepository;
    }

    public List<Status> list() {
        return statusRepository.findAll();
    }

    public Optional<Status> get(Long id) {
        return statusRepository.findById(id);
    }

    public Integer countStatusByUser(Long id) {
        Optional<Status> status = statusRepository.findById(id);
        return userRepository.countUserByStatus(status.get());
    }

    public Optional<Status> findByName(String name) {
        return statusRepository.findByName(name);
    }
}
