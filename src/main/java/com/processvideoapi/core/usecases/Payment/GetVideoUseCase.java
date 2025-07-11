package com.processvideoapi.core.usecases.Payment;

import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.domain.enumeration.State;
import com.processvideoapi.core.ports.gateways.VideoDatabaseGateway;
import com.processvideoapi.core.ports.gateways.VideoQueueGateway;
import com.processvideoapi.core.ports.gateways.VideoStorageGateway;
import com.processvideoapi.core.ports.usecases.Payment.GetVideoUseCasePort;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class GetVideoUseCase implements GetVideoUseCasePort {

    private final VideoDatabaseGateway videoDatabaseGateway;

    public GetVideoUseCase(
            VideoDatabaseGateway videoDatabaseGateway
    ) {
        this.videoDatabaseGateway = videoDatabaseGateway;
    }

    @Override
    public Video getVideo(String id) {
        return videoDatabaseGateway.get(id);
    }
}
