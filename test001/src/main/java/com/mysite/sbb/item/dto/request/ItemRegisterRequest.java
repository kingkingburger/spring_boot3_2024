package com.mysite.sbb.item.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

public record ItemRegisterRequest(
        @Schema(example = "code001")
        String code,
        @Schema(example = "name001")
        String name,
        @Schema(example = "0.1")
        BigDecimal unitPrice,
        @Schema(example = "description test")
        String description
) {
    private static ItemRegisterRequest of(String code,
                                          String name,
                                          BigDecimal unitPrice,
                                          String description) {
        return new ItemRegisterRequest(code, name, unitPrice, description);
    }
}
