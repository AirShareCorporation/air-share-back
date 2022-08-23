package dev.airshareback.services;

import dev.airshareback.controllers.dto.TopicDto;
import dev.airshareback.entities.Category;
import dev.airshareback.entities.Topic;
import dev.airshareback.entities.User;
import dev.airshareback.repositories.CategoryRepository;
import dev.airshareback.repositories.ResponseRepository;
import dev.airshareback.repositories.TopicRepository;
import dev.airshareback.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TopicService {
    private TopicRepository topicRepository;
    private UserRepository userRepository;
    private ResponseRepository responseRepository;
    private CategoryRepository categoryRepository;

    public TopicService(TopicRepository topicRepository, UserRepository userRepository, ResponseRepository responseRepository, CategoryRepository categoryRepository) {
        this.topicRepository = topicRepository;
        this.userRepository = userRepository;
        this.responseRepository = responseRepository;
        this.categoryRepository = categoryRepository;
    }

    public Topic create(@Valid TopicDto topicDto) {

        StringBuilder sb = new StringBuilder();
        Optional<User> user = userRepository.findByPseudo(topicDto.getPseudo());
        Optional<Category> category = categoryRepository.findByName(topicDto.getCategory());

        Topic topic = new Topic();
        topic.setTitle(topicDto.getTitle());
        topic.setMessage(topicDto.getMessage());
        topic.setWrittenAt(LocalDate.parse(topicDto.getWrittenAt()));
        topic.setCategory(category.get());
        topic.setUser(user.get());

        return topicRepository.save(topic);
    }

    public List<Topic> listTopic() {
        return topicRepository.findAll();
    }

    public Optional<Topic> countTopic(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return topicRepository.countTopicByCategory(category.get());
    }

    public Optional<Topic> get(Long id) {
        return topicRepository.findById(id);
    }

    public Optional<Topic> deleteTopic(Long id) {
        return topicRepository.deleteById(id);
    }

}
