package com.processvideoapi.frameworks.jpa;

import com.processvideoapi.frameworks.jpa.entity.VideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaVideoRepository extends JpaRepository<VideoEntity, Long> {

    List<VideoEntity> findAllByStatus(String videoStatus);

}
