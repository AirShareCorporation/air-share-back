package dev.airshareback.services;

import dev.airshareback.controllers.dto.ResponseDto;
import dev.airshareback.entities.Response;
import dev.airshareback.entities.Topic;
import dev.airshareback.entities.User;
import dev.airshareback.repositories.ResponseRepository;
import dev.airshareback.repositories.TopicRepository;
import dev.airshareback.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ResponseService {

    private ResponseRepository responseRepository;
    private TopicRepository topicRepository;
    private UserRepository userRepository;

    public ResponseService(ResponseRepository responseRepository, UserRepository userRepository, TopicRepository topicRepository) {
        this.responseRepository = responseRepository;
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
    }

    public List<Response> listByTopic(Long topicId) {
        return responseRepository.findByTopicId(topicId);
    }

    public List<Response> list() {
        return responseRepository.findAll();
    }


    public Response create(@Valid ResponseDto r) {

        Optional<Topic> topic = topicRepository.findById(r.getTopic());
        Optional<User> user = userRepository.findById(r.getUser());

        Response response = new Response();

        response.setContent(r.getContent());
        response.setWrittenAt(r.getWrittenAt());
        response.setTopic(topic.get());
        response.setUser(user.get());


        return responseRepository.save(response);
    }

    public  Response edit(Long responseId, @Valid ResponseDto r) {

        Optional<Response> response = responseRepository.findById(responseId);


        response.get().setContent(r.getContent());

        return responseRepository.save(response.get());
    }

    public Optional<Response> get(Long id) {
        return responseRepository.findById(id);
    }

    public Optional<Response> deleteResponse(Long respId) {
        return responseRepository.deleteById(respId);
    }

}
