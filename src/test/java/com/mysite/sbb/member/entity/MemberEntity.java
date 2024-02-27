package com.mysite.sbb.member.entity;

import com.mysite.sbb.member.dto.request.MemberRegisterRequest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberEntity {
    @Test
    @DisplayName("멤버가 생성되는지 확인하는 테스트")
    void createMember(){
        MemberRegisterRequest request = new MemberRegisterRequest("test@gmail.com", "1234", 1L);

        // given
        Member member = Member.builder().email(request.email()).password(request.password()).build();

        // when, then
        Assertions.assertThat(member.getEmail()).isEqualTo("test@gmail.com");
        Assertions.assertThat(member.getPassword()).isEqualTo("1234");


    }
}