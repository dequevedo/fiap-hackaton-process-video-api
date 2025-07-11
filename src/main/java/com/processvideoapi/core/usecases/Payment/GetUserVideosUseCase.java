package com.processvideoapi.core.usecases.Payment;

import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.ports.gateways.VideoDatabaseGateway;
import com.processvideoapi.core.ports.usecases.Payment.GetUserVideosUseCasePort;
import com.processvideoapi.core.ports.usecases.Payment.GetVideoUseCasePort;

import java.util.List;

public class GetUserVideosUseCase implements GetUserVideosUseCasePort {

    private final VideoDatabaseGateway videoDatabaseGateway;

    public GetUserVideosUseCase(
            VideoDatabaseGateway videoDatabaseGateway
    ) {
        this.videoDatabaseGateway = videoDatabaseGateway;
    }

    @Override
    public List<Video> getAllVideosByUserId(String id) {
        return videoDatabaseGateway.getAllVideosByUserId(id);
    }
}
