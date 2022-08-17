package dev.airshareback.repositories;

import dev.airshareback.entities.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Integer> {
}
