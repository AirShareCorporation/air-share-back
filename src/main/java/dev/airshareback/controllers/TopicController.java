package dev.airshareback.controllers;

import dev.airshareback.controllers.dto.TopicDto;
import dev.airshareback.entities.Topic;
import dev.airshareback.repositories.TopicRepository;
import dev.airshareback.services.TopicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/")
public class TopicController {

    private TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @GetMapping("topic")
    public List<Topic> topics() {
        return this.topicService.listTopic();
    }

    @GetMapping("topic/{id}")
    public Optional<Topic> get(@PathVariable Long id) {
        return this.topicService.get(id);
    }

    @PostMapping("topic")
    public Topic create(@RequestBody TopicDto topicDto) {
        return this.topicService.create(topicDto);
    }

    @DeleteMapping("topic/{id}")
    void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }
}
