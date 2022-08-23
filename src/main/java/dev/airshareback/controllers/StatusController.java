package dev.airshareback.controllers;

import dev.airshareback.entities.Status;
import dev.airshareback.entities.Topic;
import dev.airshareback.services.StatusService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/")
public class StatusController {

    private StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("status")
    public List<Status> statusList() {
        return this.statusService.list();
    }

    @GetMapping("status/{id}")
    public Optional<Status> getStatusById(@PathVariable Long id) {
        return this.statusService.get(id);
    }

    @GetMapping("status/users-count/{id}")
    public Integer countStatusByUser(@PathVariable Long id) {
        return this.statusService.countStatusByUser(id);
    }
}
