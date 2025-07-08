package com.processvideoapi.frameworks.sqs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.InputStream;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SQSVideoObject {

    private String key;

    private long contentLength;

    private String contentType;

}