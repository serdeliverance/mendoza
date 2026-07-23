package io.github.mendoza.katas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LengthOfLastWordTest {

  @Test
  public void test() {
    int result = LengthOfLastWord.solution_3("Today I went to the office");

    assertThat(result).isEqualTo(6);
  }

  @Test
  public void whenEmptyStringItShouldReturnZero() {
    int result = LengthOfLastWord.solution_3("");

    assertThat(result).isEqualTo(0);
  }

  @Test
  public void whenOneWordItShouldReturnLengthOfIt() {
    int result = LengthOfLastWord.solution_3("went");

    assertThat(result).isEqualTo(4);
  }

  @Test
  public void whenContainsSpecialCharactersAndSpacesItShouldReturnZero() {
    int result = LengthOfLastWord.solution_3("   1231123(*!@&&#@*(   ");

    assertThat(result).isEqualTo(0);
  }

  @Test
  public void whenASingleLetterItShouldReturn1() {
    int result = LengthOfLastWord.solution_3("a");

    assertThat(result).isEqualTo(1);
  }
}
