package dev.airshareback.repositories;

import dev.airshareback.entities.Response;
import dev.airshareback.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ResponseRepository extends JpaRepository<Response, Integer> {

    public List<Response> findByTopicId(Long TopicId);

    public  Optional<Response> findById(Long id);

}
