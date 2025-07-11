package com.processvideoapi.shared.config;

import com.processvideoapi.adapters.controllers.VideoController;
import com.processvideoapi.core.ports.gateways.VideoDatabaseGateway;
import com.processvideoapi.core.ports.gateways.VideoQueueGateway;
import com.processvideoapi.core.ports.gateways.VideoStorageGateway;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;
import com.processvideoapi.core.usecases.Payment.ProcessVideoUseCase;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public VideoController paymentController(ProcessVideoUseCasePort createPaymentUseCasePort) {
        return new VideoController(createPaymentUseCasePort);
    }

    @Bean
    public ProcessVideoUseCasePort createOrderUseCasePort(VideoDatabaseGateway videoDatabaseGateway, VideoStorageGateway videoStorageGateway, VideoQueueGateway videoQueueGateway) {
        return new ProcessVideoUseCase(videoDatabaseGateway, videoStorageGateway, videoQueueGateway);
    }
}
