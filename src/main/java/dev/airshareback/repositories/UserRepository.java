package dev.airshareback.repositories;

import dev.airshareback.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Long id);

    Optional<User> findByPseudo(String pseudo);

    Optional<User> findByPassword(String password);
}
