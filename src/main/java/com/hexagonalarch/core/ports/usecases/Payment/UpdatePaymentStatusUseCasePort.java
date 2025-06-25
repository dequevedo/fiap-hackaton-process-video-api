package com.hexagonalarch.core.ports.usecases.Payment;

import com.hexagonalarch.core.domain.Payment;
import com.hexagonalarch.core.domain.enumeration.PaymentStatus;

public interface UpdatePaymentStatusUseCasePort {
    Payment updateStatusPayment(Long orderId, String paymentStatus);
}
