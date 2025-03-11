package com.wannabeWhatsapp.demo.model;

import java.util.UUID;

public class User {
    private String id;
    private String username;
    private boolean isInfluencer;
    private String phoneNumber;

    public User(String username, boolean isInfluencer, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.isInfluencer = isInfluencer;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isInfluencer() {
        return isInfluencer;
    }

    public void setInfluencer(boolean influencer) {
        isInfluencer = influencer;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
