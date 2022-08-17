package dev.airshareback.controllers.dto;

import java.io.Serializable;
import java.util.Objects;

public class CategoryDto implements Serializable {
    private final String name;

    public CategoryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
