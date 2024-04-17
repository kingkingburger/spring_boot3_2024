package com.mysite.sbb.basic.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

public class BasicRequest {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class BasicCreateRequest {

        @NotBlank(message = "code를 입력해주세요")
        private String code;

        @Builder
        private BasicCreateRequest(
                String code
        ) {
            this.code = code;
        }


    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class BasicUpdateRequest {
        @NotBlank(message = "code를 입력해주세요")
        private String code;

        @Builder
        private BasicUpdateRequest(
                String code
        ) {
            this.code = code;
        }
    }
}
