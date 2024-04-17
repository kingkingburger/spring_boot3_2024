package com.mysite.sbb.company.service.dto.response;

import com.mysite.sbb.company.entity.Company;
import com.mysite.sbb.company.service.dto.response.CompanyResponse;
import com.mysite.sbb.common.entity.BaseTimeEntity;
import com.mysite.sbb.common.entity.BaseTimeResponse;
import com.mysite.sbb.company.entity.Company;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Getter
public class CompanyResponse {
    @Getter
    @SuperBuilder
    public static class CompanyGetResponse extends BaseTimeResponse{
        private final Long id;
        private final String code;

        public static CompanyGetResponse of(Company company){
            log.info("company info: {}", company.getCreatedAt());
            return CompanyGetResponse.builder()
                    .id(company.getId())
                    .code(company.getCode())
                    .createdAt(company.getCreatedAt())
                    .updatedAt(company.getUpdatedAt())
                    .deletedAt(company.getDeletedAt())
                    .build();
        }
        // List<Company>를 받아 List<CompanyGetResponse>를 반환하는 of 메소드
        public static List<CompanyResponse.CompanyGetResponse> ofList(List<Company> companys) {
            return companys.stream().map(company -> {
                log.info("company info: {}", company.getCreatedAt());
                return CompanyResponse.CompanyGetResponse.builder()
                        .id(company.getId())
                        .code(company.getCode())
                        .createdAt(company.getCreatedAt())
                        .updatedAt(company.getUpdatedAt())
                        .deletedAt(company.getDeletedAt())
                        .build();
            }).collect(Collectors.toList());
        }
    }

}
