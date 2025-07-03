package com.processvideoapi.core.usecases.Payment;
import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.ports.gateways.VideoDatabaseGateway;
import com.processvideoapi.core.ports.gateways.VideoStorageGateway;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class ProcessVideoUseCase implements ProcessVideoUseCasePort {

    private final VideoDatabaseGateway videoDatabaseGateway;

    private final VideoStorageGateway videoStorageGateway;

    public ProcessVideoUseCase(VideoDatabaseGateway videoDatabaseGateway, VideoStorageGateway videoStorageGateway) {
        this.videoDatabaseGateway = videoDatabaseGateway;
        this.videoStorageGateway = videoStorageGateway;
    }

    @Override
    public Video processVideo(Video video, MultipartFile file) {
        video.setUserId("someUserId");
        video.setSize(file.getSize());

        videoDatabaseGateway.save(video);

        try (InputStream inputStream = file.getInputStream()) {
            videoStorageGateway.upload(
                    file.getOriginalFilename(),
                    inputStream,
                    video.getSize(),
                    file.getContentType()
            );
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo", e);
        }

        return video;
    }

}