package dev.airshareback.services;

import dev.airshareback.controllers.dto.TopicDto;
import dev.airshareback.entities.Topic;
import dev.airshareback.entities.User;
import dev.airshareback.repositories.ResponseRepository;
import dev.airshareback.repositories.TopicRepository;
import dev.airshareback.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class TopicService {
    private TopicRepository topicRepository;
    private UserRepository userRepository;
    private ResponseRepository responseRepository;

    public TopicService(TopicRepository topicRepository, UserRepository userRepository, ResponseRepository responseRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.responseRepository = responseRepository;
    }


    public Topic create(@Valid TopicDto topicDto) {

        StringBuilder sb = new StringBuilder();
        Optional<User> user = userRepository.findByFirstName(topicDto.getUser());

        Topic topic = new Topic();
        topic.setTitle(topicDto.getTitle());
        topic.setMessage(topicDto.getMessage());
        topic.setWrittenAt(LocalDate.parse(topicDto.getWritten_at()));
        topic.setUser(topic.getUser());
        

        return topicRepository.save(topic);
    }

}
