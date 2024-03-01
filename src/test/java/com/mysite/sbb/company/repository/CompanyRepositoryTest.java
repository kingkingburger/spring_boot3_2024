package com.mysite.sbb.company.repository;

import com.mysite.sbb.company.dto.request.CompanyRegisterRequest;
import com.mysite.sbb.company.entity.Company;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @DataJpaTest: Jpa를 사용하는 Repository에 대한 검증을 수행할 때 사용하는 어노테이션입니다.
 * @DataJpaTest는 @Transaction을 포함하고 있어서 1개 의 테스트가 끝나면 Rollback 해 다른 테스트에게 영향을 미치지 않습니다.
 * @DataJpaTest로 검증할 수 있는 목록은 아래와 같습니다.
 * DataSource에 대한 설정
 * CRUD가 제대로 동작하는지
 */
@DataJpaTest
class CompanyRepositoryTest {

    @Autowired
    CompanyRepository companyRepository;
    
    @Test
    @DisplayName("회사 만들기")
    void createCompany(){
        // given
        CompanyRegisterRequest request = new CompanyRegisterRequest("COM001");
        Company company = Company.builder().code(request.code()).build();

        // when
        Company result1 = companyRepository.save(company);


        // then
        Assertions.assertThat(result1.getCode()).isEqualTo(company.getCode());
    }

    @Test
    @DisplayName("회사의 리스트를 반환 하는지 확인")
    void CompanyList() {
        // given
        CompanyRegisterRequest request = new CompanyRegisterRequest("COM001");
        Company company = Company.builder().code(request.code()).build();
        Company result1 = companyRepository.save(company);

        CompanyRegisterRequest request2 = new CompanyRegisterRequest("COM002");
        Company company2 = Company.builder().code(request2.code()).build();
        Company result2 = companyRepository.save(company2);

        // when
        List<Company> companyList = companyRepository.findAll();
        
        // then
        Assertions.assertThat(companyList.size()).isEqualTo(2);

    }

}