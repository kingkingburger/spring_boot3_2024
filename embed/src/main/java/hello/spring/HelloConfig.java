package hello.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration 주석처리(컴포넌트 스캔 쓰려고)
public class HelloConfig {

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }
}
