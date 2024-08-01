package com.example.devcrew.domain.image.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.example.devcrew.domain.image.dto.CreateProfileImageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public CreateProfileImageResponse generatePresignedUrl(String bucketFolder,String fileName, String fileExtension) {
        String key = createPath(bucketFolder, fileName, fileExtension);

        GeneratePresignedUrlRequest generatePresignedUrlRequest = getGeneratePresignedUrlRequest(bucket, key, fileExtension);
        String url=amazonS3.generatePresignedUrl(generatePresignedUrlRequest).toString();
        return CreateProfileImageResponse.from(url);

    }

    //presignedUrl을 생성하는 메서드
    private GeneratePresignedUrlRequest getGeneratePresignedUrlRequest(String bucket, String fileName, String fileExtension) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucket, fileName)
                .withMethod(HttpMethod.PUT)
                .withExpiration(getPreSignedUrlExpiration());
        generatePresignedUrlRequest.addRequestParameter("x-amz-acl", "public-read");
        generatePresignedUrlRequest.addRequestParameter("Content-Type", "image/" + fileExtension);
        return generatePresignedUrlRequest;
    }

    private Date getPreSignedUrlExpiration() {
        Date expiration = new Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 2; // 2 minutes
        expiration.setTime(expTimeMillis);
        return expiration;
    }

    private String createPath(String bucketFolder, String fileName, String fileExtension) {
        String fileId = createFileId();
        return String.format("%s/%s.%s", bucketFolder, fileId, fileName + "." + fileExtension);
    }

    private String createFileId() {
        return UUID.randomUUID().toString();
    }





}
