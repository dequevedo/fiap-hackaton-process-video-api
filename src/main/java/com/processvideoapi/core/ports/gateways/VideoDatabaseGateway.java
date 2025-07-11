package com.processvideoapi.core.ports.gateways;

import com.processvideoapi.core.domain.Video;

public interface VideoDatabaseGateway {

    Video save(Video video);

    Video get(Long id);

}