package com.processvideoapi.frameworks.rest.dto.request;

import com.processvideoapi.core.domain.enumeration.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentRequest {
    private Long orderId;
    private String status;
    private String paymentType;
    private Map<String, Object> integrationData;
}