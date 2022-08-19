package dev.airshareback.controllers.dto;

import net.bytebuddy.asm.Advice;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ResponseDto implements Serializable {
    private final String content;
    private final LocalDateTime writtenAt;
    private final boolean highlight;
    private final Long user;
    private final Long topic;

    public ResponseDto(String content, String message, boolean highlight, Long user, Long topic) {
        this.content = content;
        this.writtenAt = LocalDateTime.now();
        this.highlight = highlight;
        this.user = user;
        this.topic = topic;
    }


    public LocalDateTime getWrittenAt() {
        return writtenAt;
    }

    public boolean getHighlight() {
        return highlight;
    }

    public Long getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public Long getTopic() {
        return topic;
    }
}
