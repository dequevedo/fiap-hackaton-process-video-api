package com.processvideoapi.shared.config;

import com.processvideoapi.adapters.controllers.PaymentController;
import com.processvideoapi.core.ports.gateways.VideoGatewayPort;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;
import com.processvideoapi.core.usecases.Payment.ProcessVideoUseCase;
import com.processvideoapi.frameworks.jpa.JpaOrderRepositoryAdapter;
import com.processvideoapi.frameworks.jpa.JpaVideoRepository;
import io.awspring.cloud.autoconfigure.AwsClientCustomizer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.s3.S3ClientBuilder;
import software.amazon.awssdk.services.s3.S3Configuration;

import java.net.URI;

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

    @Bean
    public AwsClientCustomizer<S3ClientBuilder> s3Customizer() {
        return builder -> builder
                .endpointOverride(URI.create("http://localhost:4566"))
                .serviceConfiguration(
                        S3Configuration.builder().pathStyleAccessEnabled(true).build());
    }

}
