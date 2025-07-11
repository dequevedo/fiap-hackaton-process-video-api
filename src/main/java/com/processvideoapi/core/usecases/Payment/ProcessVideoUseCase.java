package com.processvideoapi.core.usecases.Payment;

import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.domain.enumeration.State;
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
        video.setState(State.EM_PROCESSAMENTO);
        video.setSize(file.getSize());

        String storageKey = file.getOriginalFilename();

        uploadToStorage(file, video);

        video.setStorageUrl(buildStorageUrl(video));

        videoDatabaseGateway.save(video);

        videoQueueGateway.send(storageKey, video.getUploadedAt());

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

    private String buildStorageUrl(Video video) {
        String bucketName = videoStorageGateway.getBucketName();
        String region = videoStorageGateway.getRegion();
        String storageKey = video.getFileName();

        return String.format(
                "https://%s.s3.%s.amazonaws.com/%s",
                bucketName,
                region,
                storageKey
        );
    }
}
