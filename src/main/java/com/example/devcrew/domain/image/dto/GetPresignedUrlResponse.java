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

    private final String imageUrl;


    public static GetPresignedUrlResponse of(String presignedUrl,String imageUrl){
        return GetPresignedUrlResponse.builder()
                .presignedUrl(presignedUrl)
                .imageUrl("https://devcrew.s3.ap-northeast-2.amazonaws.com/"+imageUrl)
                .build();
    }
}
