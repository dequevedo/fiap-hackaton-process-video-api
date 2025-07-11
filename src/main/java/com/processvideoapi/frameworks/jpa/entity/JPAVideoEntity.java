package com.processvideoapi.frameworks.jpa.entity;

import com.processvideoapi.core.domain.enumeration.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JPAVideoEntity {

    @Id
    private String id;

    String fileName;

    String userId;

    String storageUrl;

    State state;

    LocalDateTime uploadedAt;

    Long size;

}