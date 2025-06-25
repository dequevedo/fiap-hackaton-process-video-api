package com.hexagonalarch.core.domain;
import com.hexagonalarch.core.domain.enumeration.PaymentStatus;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;

public class Payment {
    private String id;
    private Long orderId;
    private String status;
    private String paymentType;
    private Map<String, Object> integrationData;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Payment() {
    }

    public Payment(String id, Long orderId, String status, String paymentType, Map<String, Object> integrationData, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
        this.paymentType = paymentType;
        this.integrationData = integrationData;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Payment(String id, Long orderId, String status, String paymentType) {
        this.id = id;
        this.orderId = orderId;
        this.status = status;
        this.paymentType = paymentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Map<String, Object> getIntegrationData() {
        return integrationData;
    }

    public void setIntegrationData(Map<String, Object> integrationData) {
        this.integrationData = integrationData;
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
}
