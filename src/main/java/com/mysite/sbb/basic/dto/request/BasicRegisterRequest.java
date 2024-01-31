package com.mysite.sbb.basic.dto.request;

public record BasicRegisterRequest(
        String email,
        String password
) {

    private static BasicRegisterRequest of(String email, String password){
        return new BasicRegisterRequest(email, password);
    }
}
