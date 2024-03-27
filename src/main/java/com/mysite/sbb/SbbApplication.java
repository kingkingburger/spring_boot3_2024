package com.mysite.sbb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableCaching // caching 기능 필요하다고 알림
public class SbbApplication {

  public static void main(String[] args) {
    SpringApplication.run(SbbApplication.class, args);
  }
}
