package com.processvideoapi.core.ports.usecases.Payment;

import com.processvideoapi.core.domain.Payment;

public interface ProcessVideoUseCasePort {
    Payment createPayment(Payment payment);
}
