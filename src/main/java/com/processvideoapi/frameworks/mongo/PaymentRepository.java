package com.processvideoapi.frameworks.mongo;
import com.processvideoapi.frameworks.mongo.entity.PaymentDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends MongoRepository<PaymentDocument, String> {
    List<PaymentDocument> findAllByOrderId(Long orderId);
}
