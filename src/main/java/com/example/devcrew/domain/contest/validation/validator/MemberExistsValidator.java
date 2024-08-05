package com.example.devcrew.domain.contest.validation.validator;

import com.example.devcrew.domain.contest.validation.annotation.MemberExists;
import com.example.devcrew.domain.member.repository.MemberRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberExistsValidator implements ConstraintValidator<MemberExists, Long> {

    private final MemberRepository memberRepository;

    @Override
    public void initialize(MemberExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        boolean exists = memberRepository.existsById(value);
        System.out.println("MemberExistsValidator - ID: " + value + ", Exists: " + exists);

        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("해당하는 멤버가 존재하지 않습니다.").addConstraintViolation();
        }

        return exists;
    }
}