package com.processvideoapi.core.usecases.Payment;

import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.ports.gateways.VideoDatabaseGateway;
import com.processvideoapi.core.ports.gateways.VideoStorageGateway;
import com.processvideoapi.core.ports.gateways.VideoQueueGateway;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public class ProcessVideoUseCase implements ProcessVideoUseCasePort {

    private final VideoDatabaseGateway videoDatabaseGateway;
    private final VideoStorageGateway videoStorageGateway;
    private final VideoQueueGateway videoQueueGateway;

    public ProcessVideoUseCase(
            VideoDatabaseGateway videoDatabaseGateway,
            VideoStorageGateway videoStorageGateway,
            VideoQueueGateway videoQueueGateway
    ) {
        this.videoDatabaseGateway = videoDatabaseGateway;
        this.videoStorageGateway = videoStorageGateway;
        this.videoQueueGateway = videoQueueGateway;
    }

    @Override
    public Video processVideo(Video video, MultipartFile file) {
        video.setUserId("someUserId"); // TODO: pegar o ID real do usuário
        video.setSize(file.getSize());

        uploadToStorage(file, video);

        videoDatabaseGateway.save(video);

        videoQueueGateway.send(video);

        return video;
    }

    private void uploadToStorage(MultipartFile file, Video video) {
        try (InputStream inputStream = file.getInputStream()) {
            videoStorageGateway.upload(
                    file.getOriginalFilename(),
                    inputStream,
                    video.getSize(),
                    file.getContentType()
            );
        } catch (IOException e) {
            throw new RuntimeException("Erro ao fazer upload para o S3", e);
        }
    }
}
