package com.processvideoapi.frameworks.jpa;

import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.ports.gateways.VideoGatewayPort;
import com.processvideoapi.frameworks.jpa.entity.VideoEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class JpaOrderRepositoryAdapter implements VideoGatewayPort {

    private final JpaVideoRepository jpaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Video save(Video video) {
        VideoEntity videoEntity = modelMapper.map(video, VideoEntity.class);

        VideoEntity savedOrderEntity = jpaRepository.save(videoEntity);

        return modelMapper.map(savedOrderEntity, Video.class);
    }

    @Override
    public Optional<Video> findById(Long id) {
        Optional<VideoEntity> optionalVideoEntity = jpaRepository.findById(id);
        return Optional.ofNullable(modelMapper.map(optionalVideoEntity, Video.class));
    }

}

