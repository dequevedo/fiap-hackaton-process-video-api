package com.hexagonalarch.core.usecases.Payment;
import com.hexagonalarch.core.domain.Payment;
import com.hexagonalarch.core.ports.gateways.PaymentGatewayPort;
import com.hexagonalarch.core.ports.usecases.Payment.CreatePaymentUseCasePort;

import java.time.LocalDateTime;
import java.util.Optional;

public class CreatePaymentUseCase implements CreatePaymentUseCasePort {
    private final PaymentGatewayPort paymentGatewayPort;

    public CreatePaymentUseCase(PaymentGatewayPort mercadoPagoGateway) {
        this.paymentGatewayPort = mercadoPagoGateway;
    }

    @Override
    public Payment createPayment(Payment payment) {
        payment.setStatus("PENDING");
        payment.setCreatedAt(LocalDateTime.now());

        return paymentGatewayPort.generatePayment(payment);
    }
}