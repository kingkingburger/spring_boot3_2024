package com.mysite.sbb.item.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

public record BasicRegisterRequest(
        @Schema(example = "test")
        String code
) {
    private static BasicRegisterRequest of(String code) {
        return new BasicRegisterRequest(code);
    }
}
