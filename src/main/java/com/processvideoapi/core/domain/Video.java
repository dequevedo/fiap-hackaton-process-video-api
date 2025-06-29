package com.processvideoapi.core.domain;

import java.time.LocalDateTime;

public class Video {

    private String id;

    private String fileName;

    private String userId;

    private LocalDateTime uploadedAt;

    public Video() {
    }

    public Video(String id, String fileName, String userId, LocalDateTime uploadedAt) {
        this.id = id;
        this.fileName = fileName;
        this.userId = userId;
        this.uploadedAt = uploadedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setUploadedAt(LocalDateTime uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
}
