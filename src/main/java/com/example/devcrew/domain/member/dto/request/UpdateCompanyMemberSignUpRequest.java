package com.example.devcrew.domain.member.dto.request;

import com.example.devcrew.domain.member.entity.CompanyMember;
import com.example.devcrew.domain.member.entity.CompanySize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "기업 회원 정보 등록")
public record UpdateCompanyMemberSignUpRequest(
        @Schema(description = "담당자 연락처")
        String contactNumber,

        @Schema(description = "담당자명")
        String responsiblePartyName,

        @Schema(description = "기업명")
        String companyName,

        @Schema(description = "사업자 등록 번호")
        @NotBlank(message = "사업자 등록 번호는 필수입니다.")
        String businessRegistrationNumber,

        @Schema(description = "대표자명")
        String ceoName,

        @Schema(description = "기업 구분")
        CompanySize companySize
) {
    public CompanyMember getCompanyMemberEntity() {
        return CompanyMember.builder()
                .contactNumber(contactNumber)
                .responsiblePartyName(responsiblePartyName)
                .companyName(companyName)
                .businessRegistrationNumber(businessRegistrationNumber)
                .ceoName(ceoName)
                .companySize(companySize)
                .build();
    }
}
