package com.processvideoapi.core.usecases.Payment;
import com.processvideoapi.core.domain.Payment;
import com.processvideoapi.core.ports.gateways.PaymentGatewayPort;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;

import java.time.LocalDateTime;

public class ProcessVideoUseCase implements ProcessVideoUseCasePort {
    private final PaymentGatewayPort paymentGatewayPort;

    public ProcessVideoUseCase(PaymentGatewayPort mercadoPagoGateway) {
        this.paymentGatewayPort = mercadoPagoGateway;
    }

    @Override
    public Payment createPayment(Payment payment) {
        payment.setStatus("PENDING");
        payment.setCreatedAt(LocalDateTime.now());

        return paymentGatewayPort.generatePayment(payment);
    }
}