package com.mysite.sbb.company.service;

import com.mysite.sbb.company.repository.CompanyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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


}