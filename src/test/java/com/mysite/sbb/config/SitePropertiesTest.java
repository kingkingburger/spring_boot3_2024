package com.mysite.sbb.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ConfigurationPropertiesScan
@ActiveProfiles("test") // 테스트용 프로필을 사용하여 application-test.properties를 로드
class SitePropertiesTest {
  @Autowired SiteProperties siteProperties;

  @Test
  @DisplayName("interface에 @ConfigurationProperties 넣을 때")
  void interface에_ConfigurationProperties_넣을_때() {
    assertThat(siteProperties.getGoogle()).isEqualTo("https:/google.com");
    assertThat(siteProperties.getNaver()).isEqualTo("https://www.naver.com");
  }
}
