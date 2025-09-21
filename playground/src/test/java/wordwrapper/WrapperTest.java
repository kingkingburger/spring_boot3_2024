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
    assertWraps("x\nx\nx", "xxx", 1);
    assertWraps("x\nx", "x x", 1);
    assertWraps("four\nscore\nand\nseven\nyears\nago our\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt",
        "four score and seven years ago our fathers brought forth upon this continent", 7);
  }

  private void assertWraps(String expected, String s, int width) {
    assertEquals(expected, wrap(s, width));
  }

  private String wrap(String text, int length) {
    if(text == null)
      return "";
    if(text.length() <= length)
      return text;
    else{
      int breakPoint = text.lastIndexOf(" ", length); // length 까지 마지막으로 space가 발생한 위치 확인
      if(breakPoint == -1)
        breakPoint = length;
      return text.substring(0, breakPoint) + "\n" + wrap(text.substring(breakPoint).trim(), length);
    }
  }
}
