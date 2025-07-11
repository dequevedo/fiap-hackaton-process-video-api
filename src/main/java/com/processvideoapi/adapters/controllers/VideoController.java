package com.processvideoapi.adapters.controllers;

import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;
import org.springframework.web.multipart.MultipartFile;

public class VideoController {

    private final ProcessVideoUseCasePort processVideoUseCasePort;

    public VideoController(ProcessVideoUseCasePort createPaymentUseCasePort) {
        this.processVideoUseCasePort = createPaymentUseCasePort;
    }

    public Video processVideo(Video payment, MultipartFile file){
        return processVideoUseCasePort.processVideo(payment, file);
    }

}
