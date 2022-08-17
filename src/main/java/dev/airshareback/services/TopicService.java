package dev.airshareback.services;

import dev.airshareback.controllers.dto.TopicDto;
import dev.airshareback.entities.*;
import dev.airshareback.repositories.ResponseRepository;
import dev.airshareback.repositories.TopicRepository;
import dev.airshareback.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    private TopicRepository topicRepository;
    private UserService userService;
    private CategoryService categoryService;
    private ResponseRepository responseRepository;

    public TopicService(TopicRepository topicRepository, UserService userService, ResponseRepository responseRepository, CategoryService categoryService) {
        this.topicRepository = topicRepository;
        this.userService = userService;
        this.responseRepository = responseRepository;
        this.categoryService = categoryService;
    }

    public Topic create(@Valid TopicDto topicDto) {

        StringBuilder sb = new StringBuilder();
        Optional<User> user = userService.findByFirst_name(topicDto.getUser());
        Optional<Category> category =  categoryService.findByName(topicDto.getCategory());

        if (user.isEmpty()) {
            sb.append("User inexistant");
        }

        if (category.isEmpty()) {
            sb.append("Category inexistante");
        }

        Topic topic = new Topic();
        topic.setTitle(topicDto.getTitle());
        topic.setMessage(topicDto.getMessage());
        topic.setWritten_at(LocalDate.parse(topicDto.getWritten_at()));
        topic.setCategory(category.get());
        topic.setHighlight(topicDto.getHighlight());
        topic.setUser(user.get());
        
        return topicRepository.save(topic);
    }

    public List<Topic> list() {
        return topicRepository.findAll();
    }

    public Optional<Topic> get(int id) {
        return topicRepository.findById(id);
    }

}
