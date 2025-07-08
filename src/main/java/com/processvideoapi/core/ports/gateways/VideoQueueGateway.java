package com.processvideoapi.core.ports.gateways;

import java.time.LocalDateTime;

public interface VideoQueueGateway {

    void send(String storageUrl, LocalDateTime uploadedAt);

}