package com.wannabeWhatsapp.demo.service;

import com.wannabeWhatsapp.demo.model.Subscription;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SubscriptionService {
    private final List<Subscription> subscriptions = new ArrayList<>();

    public List<Subscription> getSubscriptions() {
        return new ArrayList<>(subscriptions);
    }

    public Subscription subscribe(Subscription subscription) {
        subscriptions.add(subscription);
        return subscription;
    }

    public void unsubscribe(String userId, String influencerId) {
        subscriptions.removeIf(sub -> sub.getUserId().equals(userId) && sub.getInfluencerId().equals(influencerId));
    }
}
