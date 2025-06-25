package com.processvideoapi.core.ports.usecases.Payment;

import com.processvideoapi.core.domain.dto.PaymentNotificationDto;

public interface PaymentWebhookUseCasePort {
    void processPaymentWebhook(PaymentNotificationDto paymentNotificationDto);
}
