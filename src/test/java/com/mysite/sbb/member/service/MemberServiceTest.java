package com.mysite.sbb.member.service;

import com.mysite.sbb.member.repository.MemberRepository;
import com.mysite.sbb.support.IntegrationTestSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 기본적인 테스트 입니다.
 */
@Nested
public class MemberServiceTest extends IntegrationTestSupport {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;


    /**
     * 각 테스트가 끝날 때마다 tearDown이 실행된다.
     */
    @AfterEach
    void tearDown() {
        memberRepository.deleteAllInBatch();
    }

    @Nested
    class 한개의_member_입력하는경우 {
        @DisplayName("한 개의 basic을 입력한다..")
        @Test
        void registerMember() {
            // given

            // when

            // then
        }
    }


}
