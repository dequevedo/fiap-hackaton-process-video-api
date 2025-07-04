package com.processvideoapi.frameworks.sqs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.processvideoapi.core.domain.Video;
import com.processvideoapi.core.ports.gateways.VideoQueueGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.GetQueueUrlRequest;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Component
public class SQSVideoQueueGateway implements VideoQueueGateway {

    private final SqsClient sqsClient;

    private final ObjectMapper objectMapper;

    private final String queueName;

    public SQSVideoQueueGateway(
            SqsClient sqsClient,
            ObjectMapper objectMapper,
            @Value("${spring.cloud.aws.sqs.queue-name}") String queueName
    ) {
        this.sqsClient = sqsClient;
        this.objectMapper = objectMapper;
        this.queueName = queueName;
    }

    @Override
    public void send(Video video) {
        try {
            String message = objectMapper.writeValueAsString(video);

            String queueUrl = sqsClient.getQueueUrl(
                    GetQueueUrlRequest.builder()
                            .queueName(queueName)
                            .build()
            ).queueUrl();

            SendMessageRequest request = SendMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .messageBody(message)
                    .build();

            sqsClient.sendMessage(request);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao serializar vídeo para JSON", e);
        }
    }
}
