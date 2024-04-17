package com.mysite.sbb.member.dto.request;

import com.mysite.sbb.company.entity.Company;
import com.mysite.sbb.member.entity.Member;

public record MemberRegisterRequest(
        String email,
        String password,
        Long companyId

) {

    private static MemberRegisterRequest of(String email, String password, Long companyId){
        return new MemberRegisterRequest(email, password, companyId);
    }

    public Member toEntity(Company company){
        return Member.builder()
                .email(email)
                .password(password)
                .company(company)
                .build();
    }
}
