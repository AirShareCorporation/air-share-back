package dev.airshareback.controllers.dto;

import java.io.Serializable;

public class StatusDto implements Serializable {
    private final String name;

    public StatusDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
