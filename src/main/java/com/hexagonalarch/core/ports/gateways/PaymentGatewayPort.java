package com.hexagonalarch.core.ports.gateways;

import com.hexagonalarch.core.domain.Payment;

import java.util.List;

public interface PaymentGatewayPort {
    Payment generatePayment(Payment payment);
    List<Payment> getPaymentsByOrderId(Long orderId);
    Payment updatePaymentStatus(Long orderId, String status);
}
