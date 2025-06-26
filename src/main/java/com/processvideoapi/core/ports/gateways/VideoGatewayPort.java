package com.processvideoapi.core.ports.gateways;

import com.processvideoapi.core.domain.Video;

public interface VideoGatewayPort {

    Video save(Video video);

}