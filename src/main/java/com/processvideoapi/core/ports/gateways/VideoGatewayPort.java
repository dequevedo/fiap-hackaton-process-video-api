package com.processvideoapi.core.ports.gateways;

import com.processvideoapi.core.domain.Video;

import java.util.Optional;

public interface VideoGatewayPort {

    Video save(Video video);

    Optional<Video> findById(Long id);

}