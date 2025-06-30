package com.processvideoapi.core.ports.usecases.Payment;

import com.processvideoapi.core.domain.Video;
import org.springframework.web.multipart.MultipartFile;

public interface ProcessVideoUseCasePort {

    Video processVideo(Video video, MultipartFile file);

}
