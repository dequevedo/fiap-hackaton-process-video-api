package com.processvideoapi.core.ports.usecases.Payment;

import com.processvideoapi.core.domain.Payment;

import java.util.List;

public interface GetPaymentByOrderUseCasePort {
    List<Payment> getPaymentByOrderId(Long orderId);
}
