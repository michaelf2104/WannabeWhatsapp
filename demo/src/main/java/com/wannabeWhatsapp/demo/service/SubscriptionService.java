package com.wannabeWhatsapp.demo.service;

import com.wannabeWhatsapp.demo.model.Subscription;
import com.wannabeWhatsapp.demo.repository.SubscriptionRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }
}
