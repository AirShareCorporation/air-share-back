package dev.airshareback.repositories;

import dev.airshareback.entities.Response;
import dev.airshareback.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

public interface ResponseRepository extends JpaRepository<Response, Integer> {

    List<Response> findByTopicId(Long TopicId);
    Optional<Response> findById(Long id);

    Optional<Response> deleteById(Long respId);
}
