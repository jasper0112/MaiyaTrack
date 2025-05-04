package com.maiyatrack.repository;

import com.maiyatrack.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findByUserId(String userId);
    List<Notification> findByUserIdAndIsRead(String userId, boolean isRead);
    List<Notification> findByUserIdAndType(String userId, String type);
    List<Notification> findByUserIdAndNotificationChannel(String userId, String channel);
} 