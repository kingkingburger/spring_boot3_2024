package com.mysite.sbb.company.entity;

import com.mysite.sbb.company.dto.request.CompanyRegisterRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CompanyTest {
    @Test
    @DisplayName("회사가 생성되는지 확인하는 테스트")
    void createCompany(){
        CompanyRegisterRequest request = new CompanyRegisterRequest("COM001");

        // given
        Company company = Company.builder().code(request.code()).build();

        // when, then
        Assertions.assertThat(company.getCode()).isEqualTo("COM001");
    }

    @Test
    @DisplayName("회사를 업데이트 확인하는 테스트")
    void updateCompany(){
        CompanyRegisterRequest request = new CompanyRegisterRequest("COM001");

        // given
        Company company = Company.builder().code(request.code()).build();

        // when
        company.update("COM002");

        // then
        Assertions.assertThat(company.getCode()).isEqualTo("COM002");
    }
}