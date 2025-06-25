package com.processvideoapi.shared.config;

import com.processvideoapi.adapters.controllers.PaymentController;
import com.processvideoapi.core.ports.gateways.*;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;
import com.processvideoapi.core.usecases.Payment.ProcessVideoUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PaymentController paymentController(
            ProcessVideoUseCasePort createPaymentUseCasePort){
        return new PaymentController(createPaymentUseCasePort);
    }

    @Bean
    public ProcessVideoUseCasePort createPaymentUseCasePort(PaymentGatewayPort paymentGatewayPort){
        return new ProcessVideoUseCase(paymentGatewayPort);
    }

}
