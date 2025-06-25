package com.processvideoapi.core.ports.usecases.Payment;

import com.processvideoapi.core.domain.Payment;

public interface CreatePaymentUseCasePort {
    Payment createPayment(Payment payment);
}
