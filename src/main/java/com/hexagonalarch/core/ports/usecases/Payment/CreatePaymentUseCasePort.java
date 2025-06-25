package com.hexagonalarch.core.ports.usecases.Payment;

import com.hexagonalarch.core.domain.Payment;

public interface CreatePaymentUseCasePort {
    Payment createPayment(Payment payment);
}
