package dev.airshareback.repositories;

import dev.airshareback.entities.Category;
import dev.airshareback.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
    Optional<Topic> findById(Long id);
    Optional<Topic> deleteById(Long id);
    Optional<Topic> countTopicByCategory(Category category);
}
