package com.processvideoapi.frameworks.jpa;

import com.processvideoapi.frameworks.jpa.entity.JPAVideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaVideoRepository extends JpaRepository<JPAVideoEntity, String> {

    List<JPAVideoEntity> findAllByUserId(String userId);

}
