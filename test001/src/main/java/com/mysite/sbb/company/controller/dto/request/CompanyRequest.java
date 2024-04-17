package com.mysite.sbb.company.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CompanyRequest {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CompanyCreateRequest {

        @NotBlank(message = "code를 입력해주세요")
        private String code;

        @Builder
        private CompanyCreateRequest(
                String code
        ) {
            this.code = code;
        }


    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CompanyUpdateRequest {
        @NotBlank(message = "code를 입력해주세요")
        private String code;

        @Builder
        private CompanyUpdateRequest(
                String code
        ) {
            this.code = code;
        }
    }
}
