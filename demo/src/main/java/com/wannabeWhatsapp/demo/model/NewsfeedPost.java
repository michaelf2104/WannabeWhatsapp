package com.wannabeWhatsapp.demo.model;

import java.time.LocalDateTime;

public class NewsfeedPost {
    private String id;
    private String influencerId;
    private String content;
    private LocalDateTime timestamp;

    public NewsfeedPost(String influencerId, String content, LocalDateTime timestamp) {
        this.id = java.util.UUID.randomUUID().toString();
        this.influencerId = influencerId;
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public String getInfluencerId() {
        return influencerId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
