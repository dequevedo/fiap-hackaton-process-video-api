package com.processvideoapi.core.usecases.Payment;

import com.processvideoapi.core.domain.Payment;
import com.processvideoapi.core.ports.gateways.PaymentGatewayPort;
import com.processvideoapi.core.ports.usecases.Payment.UpdatePaymentStatusUseCasePort;


public class UpdatePaymentStatusUseCase implements UpdatePaymentStatusUseCasePort {

    private final PaymentGatewayPort gateway;

    public UpdatePaymentStatusUseCase(PaymentGatewayPort gateway) {
        this.gateway = gateway;
    }

    @Override
    public Payment updateStatusPayment(Long orderId, String newStatus) {
        return gateway.updatePaymentStatus(orderId, newStatus);
    }
}