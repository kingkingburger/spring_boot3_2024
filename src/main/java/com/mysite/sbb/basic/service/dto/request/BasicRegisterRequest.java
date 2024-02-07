package com.mysite.sbb.basic.service.dto.request;

public record BasicRegisterRequest(
        String code
) {
    private static BasicRegisterRequest of(String code){
        return new BasicRegisterRequest(code);
    }
}
