package com.mysite.sbb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @SpringBootApplication 어노테이션은 @Configuration, @EnableAutoConfiguration, @ComponentScan 어노테이션들의 조합
 * JpaConfig 클래스에 @EnableJpaAuditing을 선언하고 @Configuration을 붙여 이 클래스를 스프링 구성 클래스로 만들었습니다.
 * 이 구성 클래스는 스프링 컨테이너에 의해 자동으로 감지되고 로드되며, @EnableJpaAuditing 어노테이션은 JPA Auditing을 활성화합니다.
 */
@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
