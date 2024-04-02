package com.mysite.sbb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

// configurationProperties를 사용할 때 interface의 사용을 지양할 것. 구현체가 자동생성 되지만 직관적이지 않음, 테스트 코드의 작성도 어려움
@Component
@ConfigurationProperties(prefix = "site")
public interface SiteProperties {
  String getNaver();

  String getGoogle();
}
