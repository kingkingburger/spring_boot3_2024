//package com.mysite.sbb.basic.service;
//
//import com.mysite.sbb.basic.entity.Basic;
//import com.mysite.sbb.basic.repository.BasicRepository;
//import com.mysite.sbb.basic.service.dto.request.BasicRegisterRequest;
//import com.mysite.sbb.basic.service.dto.response.BasicResponse;
//import com.mysite.sbb.support.IntegrationTestSupport;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
///**
// * 기본적인 테스트 입니다.
// */
//@Nested
//public class BasicServiceTest extends IntegrationTestSupport {
//
//    @Autowired
//    private BasicService basicService;
//
//    @Autowired
//    private BasicRepository basicRepository;
//
//
//    /**
//     * 각 테스트가 끝날 때마다 tearDown이 실행된다.
//     */
//    @AfterEach
//    void tearDown() {
//        basicRepository.deleteAllInBatch();
//    }
//
//    @Nested
//    class 한개의_basic_입력하는경우 {
//        @DisplayName("한 개의 basic을 입력한다..")
//        @Test
//        void registerMember() {
//            // given
//            BasicRegisterRequest newBasicInfo = new BasicRegisterRequest("test1");
//            Basic basic = Basic.of(newBasicInfo);
////        given(basicRepository.findByCode(anyString())).willReturn(basic);
////        given(basicRepository.save(any())).willReturn(basic);
//
//            // when
//            basicService.registerBasic(newBasicInfo);
//            Basic registedBasic = basicService.getBasicByCode(basic.getCode());
//
//            // then
//            assertThat(registedBasic.getCode()).isEqualTo("test1");
//        }
//    }
//
//    @Nested
//    class 입력한_2개_basic을_출력하는경우 {
//        @Test
//        @DisplayName("여러개의 basic을 출력")
//        void getBasicList () {
//            // given
//            BasicRegisterRequest newBasicInfo = new BasicRegisterRequest("testOne");
//            BasicRegisterRequest newBasicInfo2 = new BasicRegisterRequest("testTwo");
//
//            Basic basic = Basic.of(newBasicInfo);
//            Basic basic2 = Basic.of(newBasicInfo2);
//
////        given(basicRepository.findAll()).willReturn(Arrays.asList(basic, basic2));
////        given(basicRepository.save(any(Basic.class))).willReturn(basic).willReturn(basic2);
//
//            basicService.registerBasic(newBasicInfo);
//            basicService.registerBasic(newBasicInfo2);
//
//            // when
//            List<BasicResponse.BasicGetResponse> basicList = basicService.getAllBasic();
//
//            // then
//            assertThat(basicList.size()).isEqualTo(2);
//            assertThat(basic.getCode()).isEqualTo("testOne");
//            assertThat(basic2.getCode()).isEqualTo("testTwo");
//        }
//    }
//
//    @Nested
//    class 한개의_basic_수정하는경우 {
//        @Test
//        @DisplayName("basic 수정한다.")
//        void updateBasic() {
//            // given
//            Basic testBasic1 = new Basic(1L, "test1");
//            Basic testBasic2 = new Basic(2L, "test2");
//
////        given(basicRepository.save(any())).willReturn(testBasic1);
////        given(basicRepository.findByCode(anyString())).willReturn(testBasic1);
//
//            basicRepository.save(testBasic1);
//            basicRepository.save(testBasic2);
//
//            // when
//            Basic basic1 = basicService.getBasicByCode("test1");
//            basic1.update(testBasic2.getCode());
//
//            // then
//            assertThat(basic1.getCode()).isEqualTo("test2");
//        }
//    }
//
//
//    @Nested
//    class 한개의_basic_삭제하는 {
//        @Test
//        @DisplayName("basic 삭제한다.")
//        void deleteBasic() {
//            // given
//            Basic testBasic1 = new Basic(1L, "test1");
//            Basic basic1 = basicRepository.save(testBasic1);
//
//            // when
//            basicService.deleteBasic(basic1.getId());
//
//            // then
//            Basic basic = basicService.getBasicByCode("test1");
//            assertThat(basic).isEqualTo(null);
//
//        }
//    }
//}
