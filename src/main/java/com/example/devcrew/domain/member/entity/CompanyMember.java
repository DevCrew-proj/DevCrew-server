package com.example.devcrew.domain.member.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class CompanyMember {
    private String companyName;
    private String businessRegistrationNumber;
    private String ceoName;


    private CompanySize companySize;

}
