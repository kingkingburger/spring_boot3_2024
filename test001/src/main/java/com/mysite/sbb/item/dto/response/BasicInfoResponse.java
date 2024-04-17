package com.mysite.sbb.item.dto.response;

import com.mysite.sbb.basic.entity.Basic;

public record BasicInfoResponse(
        String code
) {
    public static BasicInfoResponse from(Basic basic) {
        return new BasicInfoResponse(
                basic.getCode()
        );
    }
}
