package com.mysite.sbb.company.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record CompanyRegisterRequest(
        @Schema(example = "test")
        String code
) {
    private static CompanyRegisterRequest of(String code) {
        return new CompanyRegisterRequest(code);
    }
}
