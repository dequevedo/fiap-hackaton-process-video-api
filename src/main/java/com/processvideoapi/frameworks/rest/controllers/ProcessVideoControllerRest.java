package com.processvideoapi.frameworks.rest.controllers;

import com.processvideoapi.adapters.controllers.PaymentController;
import com.processvideoapi.adapters.presenters.GenericConverter;
import com.processvideoapi.core.domain.Payment;
import com.processvideoapi.frameworks.rest.dto.request.ProcessVideoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/process-video")
public class ProcessVideoControllerRest {
    private final PaymentController paymentController;
    private final GenericConverter genericConverter;

    public ProcessVideoControllerRest(PaymentController paymentController, GenericConverter genericConverter) {
        this.paymentController = paymentController;
        this.genericConverter = genericConverter;
    }

    @PostMapping("/qrcode")
    public ResponseEntity<Payment> processVideo(@RequestBody ProcessVideoRequest paymentRequest) {
        Payment paymentInput = genericConverter.toDomain(paymentRequest, Payment.class);
        return ResponseEntity.ok(paymentController.createPayment(paymentInput));
    }
}
