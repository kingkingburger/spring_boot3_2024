package wordwrapper;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class WrapperTest {

  @Test
  public void should_wrap() {
    assertWraps("", null, 1);
    assertWraps("", "", 1);
    assertWraps("x", "x", 1);
    assertWraps("x\nx", "xx", 1);
  }

  private void assertWraps(String expected, String s, int width) {
    assertEquals(expected, wrap(s, width));
  }

  private String wrap(String text, int length) {
    if(text == null)
      return "";
    if(text.length() <= length)
      return text;
    else
      return text.substring(0, length) + "\n" + text.substring(length);
  }
}
