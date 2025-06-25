package com.processvideoapi.core.ports.gateways;

import com.processvideoapi.core.domain.Payment;

import java.util.List;

public interface PaymentGatewayPort {

    Payment generatePayment(Payment payment);

}
