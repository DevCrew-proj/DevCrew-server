package com.example.devcrew.domain.member.dto.request;

import com.example.devcrew.domain.member.entity.CompanyMember;
import com.example.devcrew.domain.member.entity.CompanySize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "기업 회원 정보 등록")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateCompanyMemberSignUpRequest {

    @Schema(description = "담당자 연락처")
    @NotBlank
    private String contactNumber;

    @Schema(description = "담당자명")
    @NotBlank
    private String responsiblePartyName;

    @Schema(description = "담당자 이메일")
    @NotBlank
    private String contactEmail;

    @Schema(description = "기업명")
    private String companyName;

    @Schema(description = "사업자 등록 번호")
    @NotBlank(message = "사업자 등록 번호는 필수입니다.")
    private String businessRegistrationNumber;

    @Schema(description = "대표자명")
    private String ceoName;

    @Schema(description = "기업 구분")
    private CompanySize companySize;

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
