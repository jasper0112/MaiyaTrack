package com.maiyatrack.service;

import com.maiyatrack.dto.SubscriptionDTO;
import com.maiyatrack.entity.Subscription;
import com.maiyatrack.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class SubscriptionService {
    
    @Autowired
    private SubscriptionRepository subscriptionRepository;
    
    public SubscriptionDTO createSubscription(SubscriptionDTO subscriptionDTO) {
        Subscription subscription = new Subscription();
        subscription.setUserId(subscriptionDTO.getUserId());
        subscription.setBrandIds(subscriptionDTO.getBrandIds());
        subscription.setKeywords(subscriptionDTO.getKeywords());
        subscription.setCategories(subscriptionDTO.getCategories());
        subscription.setNotifyOnNewProducts(subscriptionDTO.isNotifyOnNewProducts());
        subscription.setNotifyOnLimitedEdition(subscriptionDTO.isNotifyOnLimitedEdition());
        subscription.setNotifyOnPriceDrop(subscriptionDTO.isNotifyOnPriceDrop());
        subscription.setNotificationChannels(subscriptionDTO.getNotificationChannels());
        subscription.setCreatedAt(LocalDateTime.now());
        subscription.setUpdatedAt(LocalDateTime.now());
        subscription.setActive(true);
        
        Subscription savedSubscription = subscriptionRepository.save(subscription);
        return convertToDTO(savedSubscription);
    }
    
    public SubscriptionDTO updateSubscription(String id, SubscriptionDTO subscriptionDTO) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
                
        subscription.setBrandIds(subscriptionDTO.getBrandIds());
        subscription.setKeywords(subscriptionDTO.getKeywords());
        subscription.setCategories(subscriptionDTO.getCategories());
        subscription.setNotifyOnNewProducts(subscriptionDTO.isNotifyOnNewProducts());
        subscription.setNotifyOnLimitedEdition(subscriptionDTO.isNotifyOnLimitedEdition());
        subscription.setNotifyOnPriceDrop(subscriptionDTO.isNotifyOnPriceDrop());
        subscription.setNotificationChannels(subscriptionDTO.getNotificationChannels());
        subscription.setUpdatedAt(LocalDateTime.now());
        
        Subscription updatedSubscription = subscriptionRepository.save(subscription);
        return convertToDTO(updatedSubscription);
    }
    
    public void deleteSubscription(String id) {
        subscriptionRepository.deleteById(id);
    }
    
    public SubscriptionDTO getSubscriptionById(String id) {
        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found"));
        return convertToDTO(subscription);
    }
    
    public List<SubscriptionDTO> getUserSubscriptions(String userId) {
        return subscriptionRepository.findByUserId(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<SubscriptionDTO> getActiveSubscriptions(String userId) {
        return subscriptionRepository.findByUserIdAndIsActive(userId, true).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<SubscriptionDTO> getSubscriptionsByBrand(String brandId) {
        return subscriptionRepository.findByBrandIdsContaining(brandId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<SubscriptionDTO> getSubscriptionsByKeyword(String keyword) {
        return subscriptionRepository.findByKeywordsContaining(keyword).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public List<SubscriptionDTO> getSubscriptionsByCategory(String category) {
        return subscriptionRepository.findByCategoriesContaining(category).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private SubscriptionDTO convertToDTO(Subscription subscription) {
        SubscriptionDTO dto = new SubscriptionDTO();
        dto.setId(subscription.getId());
        dto.setUserId(subscription.getUserId());
        dto.setBrandIds(subscription.getBrandIds());
        dto.setKeywords(subscription.getKeywords());
        dto.setCategories(subscription.getCategories());
        dto.setNotifyOnNewProducts(subscription.isNotifyOnNewProducts());
        dto.setNotifyOnLimitedEdition(subscription.isNotifyOnLimitedEdition());
        dto.setNotifyOnPriceDrop(subscription.isNotifyOnPriceDrop());
        dto.setNotificationChannels(subscription.getNotificationChannels());
        dto.setCreatedAt(subscription.getCreatedAt());
        dto.setUpdatedAt(subscription.getUpdatedAt());
        dto.setActive(subscription.isActive());
        return dto;
    }
} 