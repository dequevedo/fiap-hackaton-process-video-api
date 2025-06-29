package com.processvideoapi.core.usecases.Payment;
import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.ports.gateways.VideoDatabaseGateway;
import com.processvideoapi.core.ports.gateways.VideoStorageGateway;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;

import java.io.InputStream;
import java.time.LocalDateTime;

public class ProcessVideoUseCase implements ProcessVideoUseCasePort {

    private final VideoDatabaseGateway videoDatabaseGateway;

    private final VideoStorageGateway videoStorageGateway;

    public ProcessVideoUseCase(VideoDatabaseGateway videoDatabaseGateway, VideoStorageGateway videoStorageGateway) {
        this.videoDatabaseGateway = videoDatabaseGateway;
        this.videoStorageGateway = videoStorageGateway;
    }

    @Override
    public Video processVideo(Video video) {
        video.setStatus("PENDING");
        video.setCreatedAt(LocalDateTime.now());

        videoDatabaseGateway.save(video);

        InputStream fakeStream = InputStream.nullInputStream();
        videoStorageGateway.upload("video/" + video.getId(), fakeStream, 0L, "application/octet-stream");

        return video;
    }

}