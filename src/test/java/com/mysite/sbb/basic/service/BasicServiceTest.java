package com.mysite.sbb.basic.service;

import com.mysite.sbb.basic.entity.Basic;
import com.mysite.sbb.basic.exception.BasicBusinessException;
import com.mysite.sbb.basic.exception.BasicErrorCode;
import com.mysite.sbb.basic.repository.BasicRepository;
import com.mysite.sbb.basic.service.dto.request.BasicRegisterRequest;
import com.mysite.sbb.basic.service.dto.response.BasicResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
    void registerMember() {
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

    @Test
    @DisplayName("여러개의 basic을 출력")
    void getBasicList() {
        // given
        BasicRegisterRequest newBasicInfo = new BasicRegisterRequest("testOne");
        BasicRegisterRequest newBasicInfo2 = new BasicRegisterRequest("testTwo");

        Basic basic = Basic.of(newBasicInfo);
        Basic basic2 = Basic.of(newBasicInfo2);

        given(basicRepository.findAll()).willReturn(Arrays.asList(basic, basic2));
        given(basicRepository.save(any(Basic.class))).willReturn(basic).willReturn(basic2);

        basicService.registerBasic(newBasicInfo);
        basicService.registerBasic(newBasicInfo2);

        // when
        List<BasicResponse.BasicGetResponse> basicList = basicService.getAllBasic();

        // then
        assertThat(basicList.size()).isEqualTo(2);
        assertThat(basic.getCode()).isEqualTo("testOne");
        assertThat(basic2.getCode()).isEqualTo("testTwo");
    }

    @Test
    @DisplayName("basic 수정한다.")
    void updateBasic() {
        // given
        Basic testBasic1 = new Basic(1L, "test1");
        Basic testBasic2 = new Basic(2L, "test2");

        given(basicRepository.save(any())).willReturn(testBasic1);
        given(basicRepository.findByCode(anyString())).willReturn(testBasic1);

        basicRepository.save(testBasic1);
        basicRepository.save(testBasic2);

        // when
        Basic basic1 = basicService.getBasicByCode("test1");
        basic1.update(testBasic2.getCode());

        // then
        assertThat(basic1.getCode()).isEqualTo("test2");
    }

}
