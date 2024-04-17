package com.mysite.sbb.member.dto.response;

import com.mysite.sbb.member.entity.Member;

public record MemberInfoResponse(
        String email,
        String password
) {
    public static MemberInfoResponse from(Member member) {
        return new MemberInfoResponse(
                member.getEmail(),
                member.getPassword()
        );
    }
}
