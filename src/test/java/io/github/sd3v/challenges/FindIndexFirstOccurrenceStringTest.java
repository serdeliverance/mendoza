package io.github.sd3v.challenges;

import static io.github.sd3v.challenges.FindIndexFirstOccurrenceString.findIndexFirstOccurrenceString;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FindIndexFirstOccurrenceStringTest {

  @Test
  public void scenario1() {
    var result = findIndexFirstOccurrenceString("sad", "sadbutsad");
    assertEquals(0, result);
  }

  @Test
  public void scenario2() {
    var result = findIndexFirstOccurrenceString("sergio", "hola ser soy sergio sergio");
    assertEquals(13, result);
  }

  @Test
  public void scenario3() {
    var result = findIndexFirstOccurrenceString("leeto", "leetcode");
    assertEquals(-1, result);
  }
}
