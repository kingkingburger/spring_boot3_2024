package com.mysite.sbb.basic.service;

import com.mysite.sbb.basic.entity.Basic;
import com.mysite.sbb.basic.repository.BasicRepository;
import com.mysite.sbb.basic.service.dto.request.BasicRegisterRequest;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.*;


@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class BasicServiceTest {
    @InjectMocks
    private BasicService basicService;

    @Mock
    private BasicRepository basicRepository;

    @Test
    @DisplayName("한 개의 basic을 입력한다..")
    void registerMember(){
        // given
        BasicRegisterRequest newBasicInfo = new BasicRegisterRequest("test1");
        Basic basic = Basic.of(newBasicInfo);
        given(basicRepository.findByCode(anyString())).willReturn(basic);
        given(basicRepository.save(any())).willReturn(basic);

        // when
        basicService.registerBasic(newBasicInfo);
        Basic registedBasic = basicService.getBasicByCode(basic.getCode());

        // then
        assertThat(registedBasic.getCode()).isEqualTo("test1");
    }


}
