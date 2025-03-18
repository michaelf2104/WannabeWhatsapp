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
    public Subscription createSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.createSubscription(subscription);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable long id) {
        subscriptionService.deleteSubscription(id);
    }
}
