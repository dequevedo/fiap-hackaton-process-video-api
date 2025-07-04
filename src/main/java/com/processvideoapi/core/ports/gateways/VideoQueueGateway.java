package com.processvideoapi.core.ports.gateways;

import com.processvideoapi.core.domain.Video;

public interface VideoQueueGateway {

    void send(Video video);

}