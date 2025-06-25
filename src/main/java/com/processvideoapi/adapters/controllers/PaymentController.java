package com.processvideoapi.adapters.controllers;

import com.processvideoapi.core.domain.Payment;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;

public class PaymentController {
    private final ProcessVideoUseCasePort createPaymentUseCasePort;

    public PaymentController(ProcessVideoUseCasePort createPaymentUseCasePort) {
        this.createPaymentUseCasePort = createPaymentUseCasePort;
    }

    public Payment createPayment(Payment payment){
        return createPaymentUseCasePort.createPayment(payment);
    }
}
