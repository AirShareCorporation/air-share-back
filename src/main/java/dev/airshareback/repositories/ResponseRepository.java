package dev.airshareback.repositories;

import dev.airshareback.entities.Response;
import dev.airshareback.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ResponseRepository extends JpaRepository<Response, Integer> {

    public  Optional<Response> findByTopic(long TopicId);

}
