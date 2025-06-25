package com.hexagonalarch.frameworks.mongo.entity;

import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;

@Document(collection = "payments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDocument {
    @Id
    private String id;
    private Long orderId;
    private String status;
    private String paymentType;
    private Map<String, Object> integrationData;
    private Instant createdAt;
    private Instant updatedAt;
}