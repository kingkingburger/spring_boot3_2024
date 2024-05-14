package hello.pay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
public class PayConfig {
  @Bean
  @Profile("default")
  public LocalPayClient localPayClient() {
    log.info("LocalPayClient 빈 등록");
    return new LocalPayClient();
  }

  /** prod로 설정하려면 program argument에 --spring.profiles.active=prod 추가하기 */
  @Bean
  @Profile("prod")
  public ProdPayClient prodPayClient() {
    log.info("ProdPayClient 빈 등록");
    return new ProdPayClient();
  }
}
