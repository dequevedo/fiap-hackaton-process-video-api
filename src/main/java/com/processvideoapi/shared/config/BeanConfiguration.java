package com.processvideoapi.shared.config;

import com.processvideoapi.adapters.controllers.PaymentController;
import com.processvideoapi.core.ports.gateways.VideoGatewayPort;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;
import com.processvideoapi.core.usecases.Payment.ProcessVideoUseCase;
import com.processvideoapi.frameworks.jpa.JpaOrderRepositoryAdapter;
import com.processvideoapi.frameworks.jpa.JpaVideoRepository;
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
    public PaymentController paymentController(ProcessVideoUseCasePort createPaymentUseCasePort){
        return new PaymentController(createPaymentUseCasePort);
    }

    @Bean
    public ProcessVideoUseCasePort createOrderUseCasePort(VideoGatewayPort videoGatewayPort) {
        return new ProcessVideoUseCase(videoGatewayPort);
    }

}
