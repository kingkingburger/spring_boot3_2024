package com.mysite.sbb.company.service.dto.request;

public record CompanyRegisterRequest(
        String code
) {
    private static CompanyRegisterRequest of(String code){
        return new CompanyRegisterRequest(code);
    }
}
