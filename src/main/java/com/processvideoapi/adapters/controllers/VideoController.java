package com.processvideoapi.adapters.controllers;

import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.ports.usecases.Payment.GetUserVideosUseCasePort;
import com.processvideoapi.core.ports.usecases.Payment.GetVideoUseCasePort;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class VideoController {

    private final ProcessVideoUseCasePort processVideoUseCasePort;
    private final GetVideoUseCasePort getVideoUseCasePort;
    private final GetUserVideosUseCasePort getUserVideosUseCasePort;

    public VideoController(ProcessVideoUseCasePort createPaymentUseCasePort, GetVideoUseCasePort getVideoUseCasePort, GetUserVideosUseCasePort getUserVideosUseCasePort) {
        this.processVideoUseCasePort = createPaymentUseCasePort;
        this.getVideoUseCasePort = getVideoUseCasePort;
        this.getUserVideosUseCasePort = getUserVideosUseCasePort;
    }

    public Video processVideo(Video video, MultipartFile file){
        return processVideoUseCasePort.processVideo(video, file);
    }

    public Video getVideo(String id){
        return getVideoUseCasePort.getVideo(id);
    }

    public List<Video> getAllVideosByUserId(String userId) {
        return getUserVideosUseCasePort.getAllVideosByUserId(userId);
    }

}
