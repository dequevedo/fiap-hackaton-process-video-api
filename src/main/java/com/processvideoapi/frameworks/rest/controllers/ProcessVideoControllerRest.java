package com.processvideoapi.frameworks.rest.controllers;

import com.processvideoapi.adapters.controllers.PaymentController;
import com.processvideoapi.adapters.presenters.GenericConverter;
import com.processvideoapi.core.domain.Video;
import com.processvideoapi.frameworks.rest.dto.request.ProcessVideoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/process-video")
public class ProcessVideoControllerRest {

    private final PaymentController paymentController;
    private final GenericConverter genericConverter;

    public ProcessVideoControllerRest(PaymentController paymentController, GenericConverter genericConverter) {
        this.paymentController = paymentController;
        this.genericConverter = genericConverter;
    }

    @PostMapping
    public ResponseEntity<Video> processVideo(@RequestBody ProcessVideoRequest processVideoRequest) {
        Video paymentInput = genericConverter.toDomain(processVideoRequest, Video.class);
        return ResponseEntity.ok(paymentController.processVideo(paymentInput));
    }

}
