package com.maiyatrack.controller;

import com.maiyatrack.dto.SubscriptionDTO;
import com.maiyatrack.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
    
    @Autowired
    private SubscriptionService subscriptionService;
    
    @PostMapping
    public ResponseEntity<SubscriptionDTO> createSubscription(@RequestBody SubscriptionDTO subscriptionDTO) {
        SubscriptionDTO createdSubscription = subscriptionService.createSubscription(subscriptionDTO);
        return ResponseEntity.ok(createdSubscription);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> updateSubscription(@PathVariable String id, @RequestBody SubscriptionDTO subscriptionDTO) {
        SubscriptionDTO updatedSubscription = subscriptionService.updateSubscription(id, subscriptionDTO);
        return ResponseEntity.ok(updatedSubscription);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable String id) {
        subscriptionService.deleteSubscription(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionDTO> getSubscriptionById(@PathVariable String id) {
        SubscriptionDTO subscription = subscriptionService.getSubscriptionById(id);
        return ResponseEntity.ok(subscription);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SubscriptionDTO>> getUserSubscriptions(@PathVariable String userId) {
        List<SubscriptionDTO> subscriptions = subscriptionService.getUserSubscriptions(userId);
        return ResponseEntity.ok(subscriptions);
    }
    
    @GetMapping("/user/{userId}/active")
    public ResponseEntity<List<SubscriptionDTO>> getActiveSubscriptions(@PathVariable String userId) {
        List<SubscriptionDTO> subscriptions = subscriptionService.getActiveSubscriptions(userId);
        return ResponseEntity.ok(subscriptions);
    }
    
    @GetMapping("/brand/{brandId}")
    public ResponseEntity<List<SubscriptionDTO>> getSubscriptionsByBrand(@PathVariable String brandId) {
        List<SubscriptionDTO> subscriptions = subscriptionService.getSubscriptionsByBrand(brandId);
        return ResponseEntity.ok(subscriptions);
    }
    
    @GetMapping("/keyword/{keyword}")
    public ResponseEntity<List<SubscriptionDTO>> getSubscriptionsByKeyword(@PathVariable String keyword) {
        List<SubscriptionDTO> subscriptions = subscriptionService.getSubscriptionsByKeyword(keyword);
        return ResponseEntity.ok(subscriptions);
    }
    
    @GetMapping("/category/{category}")
    public ResponseEntity<List<SubscriptionDTO>> getSubscriptionsByCategory(@PathVariable String category) {
        List<SubscriptionDTO> subscriptions = subscriptionService.getSubscriptionsByCategory(category);
        return ResponseEntity.ok(subscriptions);
    }
} 