package com.processvideoapi.core.ports.gateways;

import java.io.InputStream;

public interface VideoStorageGateway {

    void upload(String key, InputStream inputStream, long contentLength, String contentType);

    String getBucketName();

    String getRegion();

}