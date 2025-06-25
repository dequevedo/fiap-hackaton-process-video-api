package com.hexagonalarch.core.ports.usecases.Payment;

import com.hexagonalarch.core.domain.Payment;

import java.util.List;

public interface GetPaymentByOrderUseCasePort {
    List<Payment> getPaymentByOrderId(Long orderId);
}
