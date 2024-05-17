package com.thresh.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@SpringBootApplication
@EnableJdbcAuditing
public class PlaygroundApplication {

  public static void main(String[] args) {
    SpringApplication.run(PlaygroundApplication.class, args);
  }
}
