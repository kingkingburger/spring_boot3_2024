package hello.config;

import memory.MemoryCondition;
import memory.MemoryController;
import memory.MemoryFinder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
// @Conditional(MemoryCondition.class) // MemoryCondition의 matches()가 true면 실행
@ConditionalOnProperty(name = "memory", havingValue = "on") // 환경 정보가 memory=on 이라면 동작, 위 주석과 같은 동작
public class MemoryConfig {

  @Bean
  public MemoryController memoryController() {
    return new MemoryController(this.memoryFinder());
  }

  @Bean
  public MemoryFinder memoryFinder() {
    return new MemoryFinder();
  }
}
