package dev.airshareback.repositories;

import dev.airshareback.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

}
