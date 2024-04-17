// [24/04/01]
package com.mysite.sbb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "site-url")
@Data
public class DatabaseProperties {
  private String naver;
  private String google;
}
