package com.hexagonalarch.frameworks.rest.controllers;

import com.hexagonalarch.adapters.controllers.PaymentController;
import com.hexagonalarch.adapters.presenters.GenericConverter;
import com.hexagonalarch.core.domain.Payment;
import com.hexagonalarch.core.domain.dto.PaymentNotificationDto;
import com.hexagonalarch.core.domain.enumeration.PaymentStatus;
import com.hexagonalarch.frameworks.rest.dto.request.CreatePaymentRequest;
import com.hexagonalarch.frameworks.rest.dto.request.MercadoPagoWebhookRequest;
import com.hexagonalarch.frameworks.rest.dto.request.UpdateOrderStatusRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentControllerRest {
    private final PaymentController paymentController;
    private final GenericConverter genericConverter;

    public PaymentControllerRest(PaymentController paymentController, GenericConverter genericConverter) {
        this.paymentController = paymentController;
        this.genericConverter = genericConverter;
    }

//    @PostMapping("/webhook")
//    public void handleMercadoPagoWebhook(@RequestBody MercadoPagoWebhookRequest request) {
//        String type = request.getType();
//        String paymentId = request.getData().getId();
//        boolean liveMode = request.isLiveMode();
//        String action = request.getAction();
//        paymentController.paymentWebhook(new PaymentNotificationDto(type, paymentId, action, liveMode));
//    }

    @PostMapping("/qrcode")
    public ResponseEntity<Payment> createPayment(@RequestBody CreatePaymentRequest paymentRequest) {
        Payment paymentInput = genericConverter.toDomain(paymentRequest, Payment.class);
        return ResponseEntity.ok(paymentController.createPayment(paymentInput));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<Payment>> getPaymentByOrderId(@PathVariable Long orderId) {
        List<Payment> payment = paymentController.getPaymentByOrderId(orderId);
        return ResponseEntity.ok(payment);
    }

    @PutMapping("/order/{orderId}/simulate")
    public ResponseEntity<Payment> updatePaymentByOrderId(@PathVariable Long orderId, @RequestBody UpdateOrderStatusRequest request) {
        String status = request.getStatus() != null ? request.getStatus().toUpperCase() : "APPROVED";
        if (!List.of("APPROVED", "PENDING", "REJECTED").contains(status)) {
            status = "APPROVED";
        }
        return ResponseEntity.ok(paymentController.updateStatusPayment(orderId, status));
    }
}
