package com.processvideoapi.core.ports.gateways;

import com.processvideoapi.core.domain.Video;

import java.util.List;

public interface VideoDatabaseGateway {

    Video save(Video video);

    Video get(String id);

    List<Video> getAllVideosByUserId(String userId);

}