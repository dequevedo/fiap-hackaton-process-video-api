package com.hexagonalarch.adapters.controllers;

import com.hexagonalarch.core.domain.Payment;
import com.hexagonalarch.core.domain.dto.PaymentNotificationDto;
import com.hexagonalarch.core.domain.enumeration.PaymentStatus;
import com.hexagonalarch.core.ports.usecases.Payment.CreatePaymentUseCasePort;
import com.hexagonalarch.core.ports.usecases.Payment.GetPaymentByOrderUseCasePort;
import com.hexagonalarch.core.ports.usecases.Payment.PaymentWebhookUseCasePort;
import com.hexagonalarch.core.ports.usecases.Payment.UpdatePaymentStatusUseCasePort;

import java.util.List;

public class PaymentController {
    private final CreatePaymentUseCasePort createPaymentUseCasePort;
    private final GetPaymentByOrderUseCasePort getPaymentByOrderUseCasePort;
    private final UpdatePaymentStatusUseCasePort updatePaymentStatusUseCasePort;

    public PaymentController(CreatePaymentUseCasePort createPaymentUseCasePort, GetPaymentByOrderUseCasePort getPaymentByOrderUseCasePort, UpdatePaymentStatusUseCasePort updatePaymentStatusUseCasePort) {
        this.createPaymentUseCasePort = createPaymentUseCasePort;
        this.getPaymentByOrderUseCasePort = getPaymentByOrderUseCasePort;
        this.updatePaymentStatusUseCasePort = updatePaymentStatusUseCasePort;
    }
    public Payment createPayment(Payment payment){
        return createPaymentUseCasePort.createPayment(payment);
    }
//
    public List<Payment> getPaymentByOrderId(Long orderId){
        return getPaymentByOrderUseCasePort.getPaymentByOrderId(orderId);
    }

    public Payment updateStatusPayment(Long orderId, String paymentStatus){
        return updatePaymentStatusUseCasePort.updateStatusPayment(orderId, paymentStatus);
    }
}
