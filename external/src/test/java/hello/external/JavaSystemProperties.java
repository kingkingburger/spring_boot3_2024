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
    }
}
