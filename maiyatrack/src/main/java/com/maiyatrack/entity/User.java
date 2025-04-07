package com.maiyatrack.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean enabled;
} 