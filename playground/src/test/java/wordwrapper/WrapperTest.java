package wordwrapper;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WrapperTest {

  @Test
  public void should_wrap() {
    assertEquals("", wrap(null, 1));
    assertEquals("", wrap("", 1));
  }

  private String wrap(String text, int length) {
    return "";
  }
}
