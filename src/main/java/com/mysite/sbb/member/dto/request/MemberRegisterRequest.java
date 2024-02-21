package com.mysite.sbb.member.dto.request;

public record MemberRegisterRequest(
        String email,
        String password

) {

    private static MemberRegisterRequest of(String email, String password){
        return new MemberRegisterRequest(email, password);
    }
}
