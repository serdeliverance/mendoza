package io.github.mendoza.katas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LongestSubstringWithoutRepeatingCharactersTest {

  // TODO unified everything into a parameterized test and remove test_2 and test_3
  @Test
  public void test() {
    int result = LongestSubstringWithoutRepeatingCharacters.solution("abcabcbb");
    assertThat(result).isEqualTo(3);
  }

  @Test
  public void test_2() {
    int result = LongestSubstringWithoutRepeatingCharacters.solution("bbbbb");
    assertThat(result).isEqualTo(1);
  }

  @Test
  public void test_3() {
    int result = LongestSubstringWithoutRepeatingCharacters.solution("pwwkew");
    assertThat(result).isEqualTo(3);
  }
}
