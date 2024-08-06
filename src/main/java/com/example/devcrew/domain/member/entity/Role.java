package com.example.devcrew.domain.member.entity;

public enum Role {
    ADMIN("ROLE_ADMIN"),
    GUEST("ROLE_GUEST"),
    NORMAL_USER("ROLE_NORMAL_USER"),
    COMPANY_USER("ROLE_COMPANY_USER");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getString() {
        return role;
    }
}

