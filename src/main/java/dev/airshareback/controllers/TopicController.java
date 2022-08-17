package dev.airshareback.controllers;

import dev.airshareback.entities.Topic;
import dev.airshareback.services.ResponseService;
import dev.airshareback.services.TopicService;
import dev.airshareback.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/")
public class TopicController {

    private TopicService topicService;
    private UserService userService;
    private ResponseService responseService;

    public TopicController(TopicService topicService, UserService userService, ResponseService responseService) {
        this.topicService = topicService;
        this.userService = userService;
        this.responseService = responseService;
    }



}
