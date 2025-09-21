package wordwrapper;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WrapperTest {

  @Test
  public void should_wrap() {
    assertWraps("", null, 1);
    assertWraps("", "", 1);
    assertWraps("x", "x", 1);
    assertWraps("xx", "x\nx", 1);
  }

  private void assertWraps(String expected, String s, int width) {
    assertEquals(expected, wrap(s, width));
  }

  private String wrap(String text, int length) {
    if(text == null)
      return "";
    return text;
  }
}
