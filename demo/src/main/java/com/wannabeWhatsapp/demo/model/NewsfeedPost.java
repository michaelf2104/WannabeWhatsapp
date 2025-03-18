package com.wannabeWhatsapp.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "newsfeed_posts")
public class NewsfeedPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "influencer_id", nullable = false)
    private User influencer;

    private String content;
    private LocalDateTime timestamp;

    public NewsfeedPost() {}

    public NewsfeedPost(User influencer, String content, LocalDateTime timestamp) {
        this.influencer = influencer;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public User getInfluencer() {
        return influencer;
    }

    public void setInfluencer(User influencer) {
        this.influencer = influencer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
