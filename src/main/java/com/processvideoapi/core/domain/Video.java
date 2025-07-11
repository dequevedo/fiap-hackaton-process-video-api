package com.processvideoapi.core.domain;

import com.processvideoapi.core.domain.enumeration.State;

import java.time.LocalDateTime;
import java.util.UUID;

public class Video {

    private final String id;

    private String fileName;

    private String userId;

    private String storageUrl;

    private State state;

    private LocalDateTime uploadedAt;

    private Long size;

    public Video() {
        this.id = UUID.randomUUID().toString();
        this.uploadedAt = LocalDateTime.now();
    }

    public Video(String fileName, String userId, State state, LocalDateTime uploadedAt) {
        this.id = UUID.randomUUID().toString();
        this.fileName = fileName;
        this.userId = userId;
        this.state = state;
        this.uploadedAt = uploadedAt;
    }

    public String getId() {
        return id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStorageUrl() {
        return storageUrl;
    }

    public void setStorageUrl(String storageUrl) {
        this.storageUrl = storageUrl;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

}
