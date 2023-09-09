package io.github.sd3v.challenges;

import static io.github.sd3v.challenges.ReverseWordsInString.reverseWords;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseWordsInStringTest {

  @Test
  public void basicScenario() {
    var result = reverseWords("the sky is blue");
    assertEquals("blue is sky the", result);
  }

  @Test
  public void withTrailingSpacesScenario() {
    var result = reverseWords("  hello world  ");
    assertEquals("world hello", result);
  }

  @Test
  public void withMultipleSpacesScenario() {
    var result = reverseWords("a good   example");
    assertEquals("example good a", result);
  }
}
