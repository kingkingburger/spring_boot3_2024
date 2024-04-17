package com.mysite.sbb.company.dto.request;

public record BasicSearchRequest(
        String createdAtFrom,
        String createdAtTo
) {
    public static BasicSearchRequest of (String createdAtFrom, String createdAtTo){
        return new BasicSearchRequest(createdAtFrom, createdAtTo);
    }
}
