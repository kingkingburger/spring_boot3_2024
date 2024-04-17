package com.mysite.sbb.member.entity;

import com.mysite.sbb.company.dto.request.CompanyRegisterRequest;
import com.mysite.sbb.company.entity.Company;
import com.mysite.sbb.member.dto.request.MemberRegisterRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberEntity {
    @Test
    @DisplayName("멤버가 생성되는지 확인하는 테스트")
    void createMember(){
        MemberRegisterRequest request = new MemberRegisterRequest("test@gmail.com", "1234", 1L);

        // given
        Member member = Member.builder().email(request.email()).password(request.password()).build();

        // when, then
        Assertions.assertThat(member.getEmail()).isEqualTo("test@gmail.com");
        Assertions.assertThat(member.getPassword()).isEqualTo("1234");
    }

    @Test
    @DisplayName("멤버를 업데이트 확인하는 테스트")
    void updateCompany(){
        MemberRegisterRequest request = new MemberRegisterRequest("test@gmail.com", "1234", 1L);
        CompanyRegisterRequest requestCompany = new CompanyRegisterRequest("COM001");

        // given
        Member member = Member.builder().email(request.email()).password(request.password()).build();
        Company company = Company.builder().code(requestCompany.code()).build();

        // when
        member.update("test1@gmail.com", "1234", company);

        // then
        Assertions.assertThat(member.getEmail()).isEqualTo("test1@gmail.com");
        Assertions.assertThat(member.getPassword()).isEqualTo("1234");
        Assertions.assertThat(member.getCompany()).isEqualTo(company);

    }


}