package com.processvideoapi.frameworks.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.processvideoapi.adapters.controllers.VideoController;
import com.processvideoapi.adapters.presenters.GenericConverter;
import com.processvideoapi.core.domain.Video;
import com.processvideoapi.frameworks.rest.dto.request.ProcessVideoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/video")
public class ProcessVideoControllerRest {

    private final VideoController videoController;
    private final GenericConverter genericConverter;

    public ProcessVideoControllerRest(VideoController videoController, GenericConverter genericConverter) {
        this.videoController = videoController;
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

        Video response = videoController.processVideo(video, file);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(response);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable String id) {
        Video response = videoController.getVideo(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<List<Video>> getAllVideosByUser(@PathVariable String userId) {
        List<Video> videos = videoController.getAllVideosByUserId(userId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(videos);
    }

}
