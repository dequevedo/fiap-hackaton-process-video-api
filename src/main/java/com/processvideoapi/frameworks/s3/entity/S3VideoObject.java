package com.processvideoapi.frameworks.s3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class S3VideoObject {

    private String key;

    private InputStream inputStream;

    private long contentLength;

    private String contentType;

}