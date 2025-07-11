package com.processvideoapi.adapters.controllers;

import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.ports.usecases.Payment.GetVideoUseCasePort;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;
import org.springframework.web.multipart.MultipartFile;

public class VideoController {

    private final ProcessVideoUseCasePort processVideoUseCasePort;
    private final GetVideoUseCasePort getVideoUseCasePort;

    public VideoController(ProcessVideoUseCasePort createPaymentUseCasePort, GetVideoUseCasePort getVideoUseCasePort) {
        this.processVideoUseCasePort = createPaymentUseCasePort;
        this.getVideoUseCasePort = getVideoUseCasePort;
    }

    public Video processVideo(Video video, MultipartFile file){
        return processVideoUseCasePort.processVideo(video, file);
    }

    public Video getVideo(Long id){
        return getVideoUseCasePort.getVideo(id);
    }

}
