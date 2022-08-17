package dev.airshareback.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "response")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String content;

    private LocalDate writtenAt;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    public Response() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getWrittenAt() {
        return writtenAt;
    }

    public void setWrittenAt(LocalDate written_at) {
        this.writtenAt = written_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
