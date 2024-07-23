package com.example.devcrew.domain.member.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Embeddable
@Getter
public class CompanyMember {
    private String companyName;
    private String businessRegistrationNumber;
    private String ceoName;

    @Enumerated(EnumType.STRING)
    private CompanySize companySize;
}
