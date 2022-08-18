package dev.airshareback.controllers.dto;

import java.io.Serializable;

public class TopicDto implements Serializable {
    private final String title;
    private final String message;
    private final String writtenAt;
    private final boolean highlight;
    private final String pseudo;
    private final String category;

    public TopicDto(String title, String message, String writtenAt, boolean highlight,
                    String user, String pseudo , String category) {
        this.title = title;
        this.message = message;
        this.writtenAt = writtenAt;
        this.highlight = highlight;
        this.category = category;
        this.pseudo = pseudo;
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
    public String getPseudo() {
        return pseudo;
    }
    public String getCategory() {
        return category;
    }
}
