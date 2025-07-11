package com.processvideoapi.core.ports.usecases.Payment;

import com.processvideoapi.core.domain.Video;

import java.util.List;

public interface GetUserVideosUseCasePort {

    List<Video> getAllVideosByUserId(String id);

}
