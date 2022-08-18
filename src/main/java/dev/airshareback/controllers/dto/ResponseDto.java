package dev.airshareback.controllers.dto;

import net.bytebuddy.asm.Advice;

import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;

public class ResponseDto implements Serializable {
    private final String content;
    private final LocalDate writtenAt;
    private final boolean highlight;
    private final String user;
    private final Long topic;

    public ResponseDto(String content, String message, boolean highlight, String user, Long topic) {
        this.content = content;
        this.writtenAt = LocalDate.now();
        this.highlight = highlight;
        this.user = user;
        this.topic = topic;
    }


    public LocalDate getWrittenAt() {
        return writtenAt;
    }

    public boolean getHighlight() {
        return highlight;
    }

    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public Long getTopic() {
        return topic;
    }
}
