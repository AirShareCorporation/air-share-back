package dev.airshareback.controllers.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class TopicDto implements Serializable {
    private final String title;
    private final String message;
    private final String written_at;
    private final boolean highlight;
    private final String user;
    private final String category;

    public TopicDto(String title, String message, String written_at, boolean highlight,
                    String user, String category) {
        this.title = title;
        this.message = message;
        this.written_at = written_at;
        this.highlight = highlight;
        this.user = user;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getWritten_at() {
        return written_at;
    }

    public boolean getHighlight() {
        return highlight;
    }

    public String getUser() {
        return user;
    }

    public String getCategory() {
        return category;
    }
}
