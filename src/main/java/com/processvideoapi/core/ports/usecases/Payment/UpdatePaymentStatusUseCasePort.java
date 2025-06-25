package com.processvideoapi.core.ports.usecases.Payment;

import com.processvideoapi.core.domain.Payment;
import com.processvideoapi.core.domain.enumeration.PaymentStatus;

public interface UpdatePaymentStatusUseCasePort {
    Payment updateStatusPayment(Long orderId, String paymentStatus);
}
