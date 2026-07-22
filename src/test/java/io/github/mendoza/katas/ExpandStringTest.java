package io.github.mendoza.katas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ExpandStringTest {

  @Test
  public void test() {
    String result = ExpandString.expandString("2[ab]3[c]1[d]");
    assertThat(result).isEqualTo("ababcccd");
  }
}
