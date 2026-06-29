package com.loopd.model;

import java.time.LocalDateTime;
import java.util.UUID;


public class User {
    private UUID id;
    private String email;
    private String displayName;
    private String avatarUrl;
    private LocalDateTime createdAt;

    public UUID getId() { return id; }
    public String getEmail() { return email; }
    public  String getDisplayName() { return displayName; }
    public String getAvatarUrl() { return avatarUrl; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setId(UUID id) { this.id = id; }
    public void setEmail(String email) { this.email = email; }
    public  void setDisplayName(String displayName){ this.displayName = displayName; }
    public  void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
