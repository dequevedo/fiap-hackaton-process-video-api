package com.hexagonalarch.frameworks.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetCustomerResponse {

    private Long id;

    private String name;

    private String email;

    private String cpf;

}