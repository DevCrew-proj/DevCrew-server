package com.example.devcrew.domain.image.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetPresignedUrlResponse {

    @Schema(description = "presignedUrl 주소 : 해당 주소로 이미지 등록")
    private final String presignedUrl;


    public static GetPresignedUrlResponse from(String presignedUrl){
        return GetPresignedUrlResponse.builder()
                .presignedUrl(presignedUrl)
                .build();
    }
}
