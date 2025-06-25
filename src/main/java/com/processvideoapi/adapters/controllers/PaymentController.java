package com.processvideoapi.adapters.controllers;

import com.processvideoapi.core.domain.Payment;
import com.processvideoapi.core.domain.dto.PaymentNotificationDto;
import com.processvideoapi.core.domain.enumeration.PaymentStatus;
import com.processvideoapi.core.ports.usecases.Payment.CreatePaymentUseCasePort;
import com.processvideoapi.core.ports.usecases.Payment.GetPaymentByOrderUseCasePort;
import com.processvideoapi.core.ports.usecases.Payment.PaymentWebhookUseCasePort;
import com.processvideoapi.core.ports.usecases.Payment.UpdatePaymentStatusUseCasePort;

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
