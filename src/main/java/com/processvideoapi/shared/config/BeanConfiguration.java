package com.processvideoapi.shared.config;

import com.processvideoapi.adapters.controllers.PaymentController;
import com.processvideoapi.core.ports.gateways.*;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;
import com.processvideoapi.core.ports.usecases.Payment.GetPaymentByOrderUseCasePort;
import com.processvideoapi.core.ports.usecases.Payment.UpdatePaymentStatusUseCasePort;
import com.processvideoapi.core.usecases.Payment.ProcessVideoUseCase;
import com.processvideoapi.core.usecases.Payment.GetPaymentByOrderUseCase;
import com.processvideoapi.core.usecases.Payment.UpdatePaymentStatusUseCase;
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
            ProcessVideoUseCasePort createPaymentUseCasePort, GetPaymentByOrderUseCasePort getPaymentByOrderUseCasePort, UpdatePaymentStatusUseCasePort updatePaymentStatusUseCasePort){
        return new PaymentController(createPaymentUseCasePort, getPaymentByOrderUseCasePort, updatePaymentStatusUseCasePort);
    }

    @Bean
    public ProcessVideoUseCasePort createPaymentUseCasePort(PaymentGatewayPort paymentGatewayPort){
        return new ProcessVideoUseCase(paymentGatewayPort);
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
