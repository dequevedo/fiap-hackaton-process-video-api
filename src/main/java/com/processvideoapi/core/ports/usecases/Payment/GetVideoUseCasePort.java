package com.processvideoapi.core.ports.usecases.Payment;

import com.processvideoapi.core.domain.Video;

public interface GetVideoUseCasePort {

    Video getVideo(Long id);

}
