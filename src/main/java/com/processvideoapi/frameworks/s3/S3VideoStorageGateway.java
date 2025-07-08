package com.processvideoapi.frameworks.s3;

import com.processvideoapi.core.ports.gateways.VideoStorageGateway;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.InputStream;

@Component
public class S3VideoStorageGateway implements VideoStorageGateway {

    private final S3Client s3Client;

    @Value("${spring.cloud.aws.s3.bucket}")
    public String bucketName;

    @Value("${spring.cloud.aws.region.static}")
    public String region;

    public S3VideoStorageGateway(S3Client s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public void upload(String key, InputStream in, long length, String contentType) {
        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key)
                .contentType(contentType)
                .build();

        s3Client.putObject(request, RequestBody.fromInputStream(in, length));
    }

    @Override
    public String getBucketName() {
        return bucketName;
    }

    @Override
    public String getRegion() {
        return region;
    }
}