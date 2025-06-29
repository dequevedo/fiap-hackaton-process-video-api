package com.processvideoapi.frameworks.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessVideoRequest {

    private String title;

    private String fileName;

    private String contentType;

    private long size;

}