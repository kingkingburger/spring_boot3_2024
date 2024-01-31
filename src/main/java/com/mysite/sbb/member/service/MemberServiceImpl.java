package com.mysite.sbb.member.service;

import com.mysite.sbb.member.dto.request.MemberRegisterRequest;
import com.mysite.sbb.member.dto.response.MemberInfoResponse;
import com.mysite.sbb.member.entity.Member;
import com.mysite.sbb.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
//@Transactional
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;

    @Override
//    @Transactional
    public void registerMember(MemberRegisterRequest request){
        Member newMember = Member.of(request);

        memberRepository.save(newMember);
    }

    @Override
//    @Transactional()
    public MemberInfoResponse getMemberInfoByEmail(String email){
        if(!memberRepository.existsMemberByEmail(email)){
            throw new RuntimeException("NOT FOUND MEMBER");
        }

        Member memberInfo = memberRepository.findMemberByEmail(email);
        return MemberInfoResponse.from(memberInfo);
    }

}
