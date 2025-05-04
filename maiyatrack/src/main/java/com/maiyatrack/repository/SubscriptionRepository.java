package com.maiyatrack.repository;

import com.maiyatrack.entity.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
    List<Subscription> findByUserId(String userId);
    List<Subscription> findByUserIdAndIsActive(String userId, boolean isActive);
    List<Subscription> findByBrandIdsContaining(String brandId);
    List<Subscription> findByKeywordsContaining(String keyword);
    List<Subscription> findByCategoriesContaining(String category);
} 