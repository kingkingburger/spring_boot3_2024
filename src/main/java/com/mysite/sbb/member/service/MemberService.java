package com.mysite.sbb.member.service;

import com.mysite.sbb.member.dto.request.MemberRegisterRequest;
import com.mysite.sbb.member.dto.response.MemberInfoResponse;

public interface MemberService {

    void registerMember(MemberRegisterRequest request);

    MemberInfoResponse getMemberInfoByEmail(String email);
}
