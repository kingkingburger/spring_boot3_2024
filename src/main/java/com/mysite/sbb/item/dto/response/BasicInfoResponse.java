package com.mysite.sbb.item.dto.response;

import com.mysite.sbb.item.entity.Item;

public record BasicInfoResponse(
        String code
) {
    public static BasicInfoResponse from(Item item) {
        return new BasicInfoResponse(
                item.getCode()
        );
    }
}
