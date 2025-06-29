package com.processvideoapi.frameworks.jpa;

import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.ports.gateways.VideoDatabaseGateway;
import com.processvideoapi.frameworks.jpa.entity.JPAVideoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaOrderRepositoryAdapter implements VideoDatabaseGateway {

    private final JpaVideoRepository jpaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Video save(Video video) {
        JPAVideoEntity videoEntity = modelMapper.map(video, JPAVideoEntity.class);

        JPAVideoEntity savedOrderEntity = jpaRepository.save(videoEntity);

        return modelMapper.map(savedOrderEntity, Video.class);
    }

}

