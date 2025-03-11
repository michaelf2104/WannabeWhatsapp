package com.wannabeWhatsapp.demo.controller;

import com.wannabeWhatsapp.demo.model.Subscription;
import com.wannabeWhatsapp.demo.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public List<Subscription> getSubscriptions() {
        return subscriptionService.getSubscriptions();
    }

    @PostMapping
    public Subscription subscribe(@RequestBody Subscription subscription) {
        return subscriptionService.subscribe(subscription);
    }

    @DeleteMapping("/{userId}/{influencerId}")
    public void unsubscribe(@PathVariable String userId, @PathVariable String influencerId) {
        subscriptionService.unsubscribe(userId, influencerId);
    }
}
