package com.wannabeWhatsapp.demo.model;

public class Subscription {
    private String userId;
    private String influencerId;

    public Subscription() {}

    public Subscription(String userId, String influencerId) {
        this.userId = userId;
        this.influencerId = influencerId;
    }

    public String getUserId() {
        return userId;
    }

    public String getInfluencerId() {
        return influencerId;
    }
}
