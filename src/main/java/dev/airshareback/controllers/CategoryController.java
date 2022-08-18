package dev.airshareback.controllers;

import dev.airshareback.controllers.dto.CategoryDto;
import dev.airshareback.controllers.dto.TopicDto;
import dev.airshareback.entities.Category;
import dev.airshareback.entities.Topic;
import dev.airshareback.services.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(allowCredentials = "true", origins = "http://localhost:4200/")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("category")
    public List<Category> listCategory() {
        return this.categoryService.list();
    }

    @GetMapping("category/{id}")
    public Optional<Category> getCategory(@PathVariable Long id) {
        return this.categoryService.getCategory(id);
    }

    @PostMapping("category")
    public Category create(@RequestBody CategoryDto categoryDto) {
        return this.categoryService.create(categoryDto);
    }
}
