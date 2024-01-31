package com.mysite.sbb.basic.dto.response;

import com.mysite.sbb.basic.entity.Basic;

public record BasicInfoResponse(
        String email,
        String password
) {
    public static BasicInfoResponse from(Basic basic) {
        return new BasicInfoResponse(
                basic.getEmail(),
                basic.getPassword()
        );
    }
}
