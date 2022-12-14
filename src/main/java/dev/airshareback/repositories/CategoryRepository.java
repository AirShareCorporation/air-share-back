package dev.airshareback.repositories;

import dev.airshareback.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    public Optional<Category> findByName(String name);

    public  Optional<Category> findById(Long id);

    Optional<Category> deleteById(Long id);
}
