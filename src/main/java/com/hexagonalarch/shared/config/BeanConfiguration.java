package com.hexagonalarch.shared.config;

import com.hexagonalarch.adapters.controllers.PaymentController;
import com.hexagonalarch.core.ports.gateways.*;
import com.hexagonalarch.core.ports.usecases.Payment.CreatePaymentUseCasePort;
import com.hexagonalarch.core.ports.usecases.Payment.GetPaymentByOrderUseCasePort;
import com.hexagonalarch.core.ports.usecases.Payment.PaymentWebhookUseCasePort;
import com.hexagonalarch.core.ports.usecases.Payment.UpdatePaymentStatusUseCasePort;
import com.hexagonalarch.core.usecases.Payment.CreatePaymentUseCase;
import com.hexagonalarch.core.usecases.Payment.GetPaymentByOrderUseCase;
import com.hexagonalarch.core.usecases.Payment.UpdatePaymentStatusUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

//    @Bean
//    public PaymentController paymentController(PaymentWebhookUseCasePort paymentWebhookUseCasePort,
//                                               CreatePaymentUseCasePort createPaymentUseCasePort,
//                                               GetPaymentByOrderUseCasePort getPaymentByOrderUseCasePort,
//                                               UpdatePaymentStatusUseCasePort updatePaymentStatusUseCasePort){
//        return new PaymentController(paymentWebhookUseCasePort, createPaymentUseCasePort, getPaymentByOrderUseCasePort, updatePaymentStatusUseCasePort);
//    }

    @Bean
    public PaymentController paymentController(
                                               CreatePaymentUseCasePort createPaymentUseCasePort, GetPaymentByOrderUseCasePort getPaymentByOrderUseCasePort, UpdatePaymentStatusUseCasePort updatePaymentStatusUseCasePort){
        return new PaymentController(createPaymentUseCasePort, getPaymentByOrderUseCasePort, updatePaymentStatusUseCasePort);
    }

    @Bean
    public CreatePaymentUseCasePort createPaymentUseCasePort(PaymentGatewayPort paymentGatewayPort){
        return new CreatePaymentUseCase(paymentGatewayPort);
    }

    @Bean
    public UpdatePaymentStatusUseCasePort updatePaymentStatusUseCasePort(PaymentGatewayPort paymentGatewayPort){
        return new UpdatePaymentStatusUseCase(paymentGatewayPort);
    }
//
    @Bean
    public GetPaymentByOrderUseCasePort getPaymentByOrderUseCasePort( PaymentGatewayPort paymentGatewayPort){
        return new GetPaymentByOrderUseCase(paymentGatewayPort);
    }
//
//    @Bean
//    public PaymentWebhookUseCasePort paymentWebhookUseCasePort(OrderPaymentGatewayPort paymentGatewayPort, OrderGatewayPort orderGatewayPort) {
//        return new PaymentWebhookUseCase(paymentGatewayPort, orderGatewayPort);
//    }
}
