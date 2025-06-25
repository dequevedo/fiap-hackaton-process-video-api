package com.processvideoapi.frameworks.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcessVideoResponse {

    private Long id;

    private String name;

    private String email;

    private String cpf;

}