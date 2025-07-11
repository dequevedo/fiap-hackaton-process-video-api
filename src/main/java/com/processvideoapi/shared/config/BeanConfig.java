package com.processvideoapi.shared.config;

import com.processvideoapi.adapters.controllers.VideoController;
import com.processvideoapi.core.ports.gateways.VideoDatabaseGateway;
import com.processvideoapi.core.ports.gateways.VideoQueueGateway;
import com.processvideoapi.core.ports.gateways.VideoStorageGateway;
import com.processvideoapi.core.ports.usecases.Payment.GetUserVideosUseCasePort;
import com.processvideoapi.core.ports.usecases.Payment.GetVideoUseCasePort;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;
import com.processvideoapi.core.usecases.Payment.GetUserVideosUseCase;
import com.processvideoapi.core.usecases.Payment.GetVideoUseCase;
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
    public VideoController paymentController(ProcessVideoUseCasePort createPaymentUseCasePort, GetVideoUseCasePort getVideoUseCasePort, GetUserVideosUseCasePort getUserVideosUseCasePort) {
        return new VideoController(createPaymentUseCasePort, getVideoUseCasePort, getUserVideosUseCasePort);
    }

    @Bean
    public ProcessVideoUseCasePort processVideoUseCasePort(VideoDatabaseGateway videoDatabaseGateway, VideoStorageGateway videoStorageGateway, VideoQueueGateway videoQueueGateway) {
        return new ProcessVideoUseCase(videoDatabaseGateway, videoStorageGateway, videoQueueGateway);
    }

    @Bean
    public GetVideoUseCasePort getVideoUseCasePort(VideoDatabaseGateway videoDatabaseGateway) {
        return new GetVideoUseCase(videoDatabaseGateway);
    }

    @Bean
    public GetUserVideosUseCasePort getUserVideosUseCasePort(VideoDatabaseGateway videoDatabaseGateway) {
        return new GetUserVideosUseCase(videoDatabaseGateway);
    }
}
