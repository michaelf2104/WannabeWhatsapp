package com.wannabeWhatsapp.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "influencer_id", nullable = false)
    private User influencer;

    public Subscription() {}

    public Subscription(User user, User influencer) {
        this.user = user;
        this.influencer = influencer;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getInfluencer() {
        return influencer;
    }

    public void setInfluencer(User influencer) {
        this.influencer = influencer;
    }
}
