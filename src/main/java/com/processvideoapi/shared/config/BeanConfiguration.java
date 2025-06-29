package com.processvideoapi.shared.config;

import com.processvideoapi.adapters.controllers.PaymentController;
import com.processvideoapi.core.ports.gateways.VideoDatabaseGateway;
import com.processvideoapi.core.ports.gateways.VideoStorageGateway;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;
import com.processvideoapi.core.usecases.Payment.ProcessVideoUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
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
    public ProcessVideoUseCasePort createOrderUseCasePort(VideoDatabaseGateway videoDatabaseGateway, VideoStorageGateway videoStorageGateway) {
        return new ProcessVideoUseCase(videoDatabaseGateway, videoStorageGateway);
    }

    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .endpointOverride(URI.create("http://localhost:4566"))
                .region(Region.US_EAST_1)
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                AwsBasicCredentials.create("test", "test")
                        )
                )
                .forcePathStyle(true)
                .build();
    }

}
