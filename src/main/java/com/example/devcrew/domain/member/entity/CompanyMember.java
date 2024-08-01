package com.example.devcrew.domain.member.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompanyMember {
    private String contactNumber;
    private String responsiblePartyName;

    private String companyName;
    private String businessRegistrationNumber;
    private String ceoName;

    @Enumerated(EnumType.STRING)
    private CompanySize companySize;

    @Builder
    public CompanyMember(String contactNumber, String responsiblePartyName, String companyName,
                         String businessRegistrationNumber, String ceoName, CompanySize companySize) {
        this.contactNumber = contactNumber;
        this.responsiblePartyName = responsiblePartyName;
        this.companyName = companyName;
        this.businessRegistrationNumber = businessRegistrationNumber;
        this.ceoName = ceoName;
        this.companySize = companySize;
    }

}
