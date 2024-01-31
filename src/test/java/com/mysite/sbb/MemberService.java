package com.mysite.sbb;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import com.mysite.sbb.member.dto.request.MemberRegisterRequest;
import com.mysite.sbb.member.dto.response.MemberInfoResponse;
import com.mysite.sbb.member.entity.Member;
import com.mysite.sbb.member.repository.MemberRepository;
import com.mysite.sbb.member.service.MemberServiceImpl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;


@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class MemberService {
    @InjectMocks
    private MemberServiceImpl memberService;

    @Mock
    private MemberRepository memberRepository;

    @Test
    @DisplayName("한 명의 멤버를 가입신다.")
    void registerMember(){
        // given
        MemberRegisterRequest newMemberInfo = new MemberRegisterRequest("test@gmail.com", "testPwd");
        Member newMember = Member.of(newMemberInfo);
        given(memberRepository.existsMemberByEmail(anyString())).willReturn(true);
        given(memberRepository.findMemberByEmail(anyString())).willReturn(newMember);
        given(memberRepository.save(any())).willReturn(newMember);

        // when
        memberService.registerMember(newMemberInfo);
        MemberInfoResponse registeredMember = memberService.getMemberInfoByEmail(newMemberInfo.email());

        // then
        assertThat(registeredMember.email()).isEqualTo("test@gmail.com");
        assertThat(registeredMember.password()).isEqualTo("testPwd");
    }

}
