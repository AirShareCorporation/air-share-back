package dev.airshareback.services;

import dev.airshareback.controllers.dto.CategoryDto;
import dev.airshareback.entities.Category;
import dev.airshareback.entities.Topic;
import dev.airshareback.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(@Valid CategoryDto categoryDto) {

        Category category = new Category();

        category.setName(categoryDto.getName());

        return categoryRepository.save(category);
    }

    public Optional<Category> findByName(String nameRubrique) {
        return categoryRepository.findByName(nameRubrique);
    }

    public List<Category> list() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategory(Long id) {
        return categoryRepository.findById(id);
    }

    public Optional<Category> deleteCategory(Long id) {
        return categoryRepository.deleteById(id);
    }

}
