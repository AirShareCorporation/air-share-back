package dev.airshareback.controllers.dto;

import java.io.Serializable;

public class TopicDto implements Serializable {
    private final String title;
    private final String message;
    private final String writtenAt;
    private final boolean highlight;
    private final String user;

    public TopicDto(String title, String message, String writtenAt, boolean highlight, String user) {
        this.title = title;
        this.message = message;
        this.writtenAt = writtenAt;
        this.highlight = highlight;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getWrittenAt() {
        return writtenAt;
    }

    public boolean getHighlight() {
        return highlight;
    }

    public String getUser() {
        return user;
    }
}
