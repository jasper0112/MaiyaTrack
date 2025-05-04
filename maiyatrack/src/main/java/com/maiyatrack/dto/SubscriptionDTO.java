package com.maiyatrack.dto;

import java.time.LocalDateTime;
import java.util.List;

public class SubscriptionDTO {
    private String id;
    private String userId;
    private List<String> brandIds;
    private List<String> keywords;
    private List<String> categories;
    private boolean notifyOnNewProducts;
    private boolean notifyOnLimitedEdition;
    private boolean notifyOnPriceDrop;
    private List<String> notificationChannels;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getBrandIds() {
        return brandIds;
    }

    public void setBrandIds(List<String> brandIds) {
        this.brandIds = brandIds;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public boolean isNotifyOnNewProducts() {
        return notifyOnNewProducts;
    }

    public void setNotifyOnNewProducts(boolean notifyOnNewProducts) {
        this.notifyOnNewProducts = notifyOnNewProducts;
    }

    public boolean isNotifyOnLimitedEdition() {
        return notifyOnLimitedEdition;
    }

    public void setNotifyOnLimitedEdition(boolean notifyOnLimitedEdition) {
        this.notifyOnLimitedEdition = notifyOnLimitedEdition;
    }

    public boolean isNotifyOnPriceDrop() {
        return notifyOnPriceDrop;
    }

    public void setNotifyOnPriceDrop(boolean notifyOnPriceDrop) {
        this.notifyOnPriceDrop = notifyOnPriceDrop;
    }

    public List<String> getNotificationChannels() {
        return notificationChannels;
    }

    public void setNotificationChannels(List<String> notificationChannels) {
        this.notificationChannels = notificationChannels;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
} 