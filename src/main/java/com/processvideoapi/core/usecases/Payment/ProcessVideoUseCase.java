package com.processvideoapi.core.usecases.Payment;
import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.ports.gateways.VideoGatewayPort;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;

import java.time.LocalDateTime;

public class ProcessVideoUseCase implements ProcessVideoUseCasePort {

    private final VideoGatewayPort videoGatewayPort;

    public ProcessVideoUseCase(VideoGatewayPort videoGatewayPort) {
        this.videoGatewayPort = videoGatewayPort;
    }

    @Override
    public Video processVideo(Video video) {
        video.setStatus("PENDING");
        video.setCreatedAt(LocalDateTime.now());

        return videoGatewayPort.save(video);
    }

}