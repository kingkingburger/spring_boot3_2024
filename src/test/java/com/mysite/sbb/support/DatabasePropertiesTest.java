package com.mysite.sbb.support;

import static org.assertj.core.api.Assertions.assertThat;

import com.mysite.sbb.config.DatabaseProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ConfigurationPropertiesScan
@ActiveProfiles("test") // 테스트용 프로필을 사용하여 application-test.properties를 로드
public class DatabasePropertiesTest {

  @Autowired DatabaseProperties databaseProperties;

  @Test
  @DisplayName("class에 @ConfigurationProperties 넣을 때")
  void class에_ConfigurationProperties_넣을_때() {
    assertThat(databaseProperties.getGoogle()).isEqualTo("https:/google.com");
    assertThat(databaseProperties.getNaver()).isEqualTo("https://www.naver.com");
  }
}
