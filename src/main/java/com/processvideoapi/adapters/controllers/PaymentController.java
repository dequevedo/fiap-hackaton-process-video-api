package com.processvideoapi.adapters.controllers;

import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.ports.usecases.Payment.ProcessVideoUseCasePort;

public class PaymentController {

    private final ProcessVideoUseCasePort processVideoUseCasePort;

    public PaymentController(ProcessVideoUseCasePort createPaymentUseCasePort) {
        this.processVideoUseCasePort = createPaymentUseCasePort;
    }

    public Video processVideo(Video payment){
        return processVideoUseCasePort.processVideo(payment);
    }

}
