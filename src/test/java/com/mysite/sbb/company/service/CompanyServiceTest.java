package com.mysite.sbb.company.service;


import com.mysite.sbb.company.service.dto.request.CompanyRegisterRequest;
import com.mysite.sbb.company.entity.Company;
import com.mysite.sbb.company.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class CompanyServiceTest {

    // Test 주체
    CompanyService companyService;

    // Test 협력자
    @MockBean
    CompanyRepository companyRepository;

    // Test를 실행하기 전마다 CompanyService에 가짜 객체를 주입시켜준다.
    @BeforeEach
    void setUp(){
        companyService = new CompanyService(companyRepository);
    }


    @Test
    @DisplayName("회사 생성 성공")
    void createCompanySuccess(){
        // given
        CompanyRegisterRequest request = new CompanyRegisterRequest("COM001");
        Company company = Company.builder().code(request.code()).build();

        Mockito.when(companyRepository.save(company)).thenReturn(company); // 가짜 객체 응답 정의

        // when
        companyService.registerCompany(request);
    }

    @Test
    @DisplayName("회사 업데이트 성공")
    void updateCompanySuccess() {
        // given
        CompanyRegisterRequest request = new CompanyRegisterRequest("COM001");
        Company company = Company.builder().code(request.code()).build();
        CompanyRegisterRequest updateRequest = new CompanyRegisterRequest("COM002");
        Company updatedCompany = Company.builder().code(updateRequest.code()).build();


        Mockito.when(companyRepository.save(company)).thenReturn(company); // 가짜 객체 응답 정의
        Mockito.when(companyRepository.findById(1L)).thenReturn(Optional.ofNullable(updatedCompany)); // 가짜 객체 응답 정의

        // when
        companyService.updateCompany(1L, updateRequest);
    }

}