package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Slf4j
@Component
public class CommandLIneBean {
  private final ApplicationArguments arguments;

  public CommandLIneBean(ApplicationArguments arguments) {
    this.arguments = arguments;
  }

  @PostConstruct
  public void init() {
    log.info("source {}", List.of(arguments.getSourceArgs()));
    log.info("optionNames {}", arguments.getOptionNames());
    Set<String> optionNames = arguments.getOptionNames();
    for (String optionName : optionNames) {
      log.info("option args {}={}", optionName, arguments.getOptionValues(optionName));
    }
  }
}
