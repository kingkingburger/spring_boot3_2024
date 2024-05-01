package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.Properties;

@Slf4j
public class JavaSystemProperties {
  public static void main(String[] args) {
    Properties properties = System.getProperties();
    for (Object key : properties.keySet()) {
      log.info("key: {}, value: {}", key, System.getProperty(String.valueOf(key)));
    }
    log.info("Java System Properties");
    String url = System.getProperty("url");
    String username = System.getProperty("username");
    String password = System.getProperty("password");
    log.info("url={}", url);
    log.info("username={}", username);
    log.info("password={}", password);
  }
}
