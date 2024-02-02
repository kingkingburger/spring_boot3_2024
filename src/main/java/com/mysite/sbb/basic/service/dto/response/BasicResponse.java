package com.mysite.sbb.basic.service.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BasicResponse {

    @Getter
    public static class BasicSearchResponse {
        private final String code;

        @Builder
        public BasicSearchResponse(String code) {
            this.code = code;
        }

        public static BasicSearchResponse of(String code) {
            return BasicSearchResponse.builder()
                    .code(code)
                    .build();
        }

    }
}
