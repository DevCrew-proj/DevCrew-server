package com.example.devcrew.domain.image.service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.example.devcrew.domain.image.dto.GetPresignedUrlResponse;
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

    public GetPresignedUrlResponse getPresignedUrl(String bucketFolder, String fileExtension) {
        String realImageUrl = createPath(bucketFolder,fileExtension);

        GeneratePresignedUrlRequest generatePresignedUrlRequest = getGeneratePresignedUrlRequest(bucket, realImageUrl, fileExtension);
        String url=amazonS3.generatePresignedUrl(generatePresignedUrlRequest).toString();
        System.out.println("생성된 url="+url);
        return GetPresignedUrlResponse.of(url,realImageUrl);

    }

    //presignedUrl을 생성하는 메서드
    private GeneratePresignedUrlRequest getGeneratePresignedUrlRequest(String bucket, String key, String fileExtension) {
        String contentType;
        switch (fileExtension.toLowerCase()) {
            case "png":
            case "jpg":
            case "jpeg":
            case "gif":
                contentType = "image/" + fileExtension.toLowerCase();
                break;
            case "pdf":
                contentType = "application/pdf";
                break;
            case "txt":
                contentType = "text/plain";
                break;
            case "doc":
            case "docx":
                contentType = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
                break;
            // 필요한 경우 다른 파일 형식도 추가 가능
            default:
                throw new IllegalArgumentException("Unsupported file type: " + fileExtension);
        }

        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(bucket, key)
                .withMethod(HttpMethod.PUT)
                .withKey(key)
                .withContentType(contentType)  // 확장자에 따른 Content-Type 설정
                .withExpiration(getPreSignedUrlExpiration());

        return generatePresignedUrlRequest;
    }

    private Date getPreSignedUrlExpiration() {
        Date expiration = new Date();
        long expTimeMillis = expiration.getTime();
        expTimeMillis += 1000 * 60 * 3; // 3분
        expiration.setTime(expTimeMillis);
        return expiration;
    }

    private String createPath(String bucketFolder,String fileExtension) {
        String fileId = createFileId();
        return bucketFolder+"/"+fileId+"."+fileExtension;
    }

    private String createFileId() {
        return UUID.randomUUID().toString();
    }





}
