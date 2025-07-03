package com.processvideoapi.core.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class Video {

    private final String id;
    private String fileName;
    private String userId;
    private LocalDateTime uploadedAt;
    private Long size;

    public Video() {
        this.id = UUID.randomUUID().toString();
        this.uploadedAt = LocalDateTime.now();
    }

    public Video(String fileName, String userId, LocalDateTime uploadedAt) {
        this.id = UUID.randomUUID().toString();
        this.fileName = fileName;
        this.userId = userId;
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
