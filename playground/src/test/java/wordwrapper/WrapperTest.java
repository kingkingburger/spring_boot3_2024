package wordwrapper;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WrapperTest {

  @Test
  public void should_wrap() {
    assertEquals("word\rword", wrap("word word", 4));
    assertEquals("a dog", wrap("a dog", 5));
  }

  private String wrap(String text, int length) {
    return text.length() > length ? text.replaceAll(" ", "\r") : text;
  }
}
