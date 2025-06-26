package com.processvideoapi.frameworks.jpa;

import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.ports.gateways.VideoGatewayPort;
import com.processvideoapi.frameworks.jpa.entity.VideoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JpaOrderRepositoryAdapter implements VideoGatewayPort {

    private final JpaVideoRepository jpaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Video save(Video video) {
        VideoEntity videoEntity = modelMapper.map(video, VideoEntity.class);

        VideoEntity savedOrderEntity = jpaRepository.save(videoEntity);

        return modelMapper.map(savedOrderEntity, Video.class);
    }

}

