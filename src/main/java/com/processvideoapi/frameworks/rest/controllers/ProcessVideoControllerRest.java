package com.processvideoapi.frameworks.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.processvideoapi.adapters.controllers.PaymentController;
import com.processvideoapi.adapters.presenters.GenericConverter;
import com.processvideoapi.core.domain.Video;
import com.processvideoapi.frameworks.rest.dto.request.ProcessVideoRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/process-video")
public class ProcessVideoControllerRest {

    private final PaymentController paymentController;
    private final GenericConverter genericConverter;

    public ProcessVideoControllerRest(PaymentController paymentController, GenericConverter genericConverter) {
        this.paymentController = paymentController;
        this.genericConverter = genericConverter;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Video> processVideo(
            @RequestPart("file") MultipartFile file,
            @RequestPart("metadata") String metadataJson
    ) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ProcessVideoRequest processVideoRequest = mapper.readValue(metadataJson, ProcessVideoRequest.class);

        Video video = genericConverter.toDomain(processVideoRequest, Video.class);
        video.setFileName(file.getOriginalFilename());

        return ResponseEntity.ok(paymentController.processVideo(video, file));
    }


}
