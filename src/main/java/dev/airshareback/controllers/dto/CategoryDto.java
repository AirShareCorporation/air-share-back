package dev.airshareback.controllers.dto;

import java.io.Serializable;
import java.util.Objects;

public class CategoryDto implements Serializable {
    private final String name_rubrique;

    public CategoryDto(String name_rubrique) {
        this.name_rubrique = name_rubrique;
    }

    public String getName_rubrique() {
        return name_rubrique;
    }
}
