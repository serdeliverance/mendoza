package io.github.mendoza.katas;

import static io.github.mendoza.katas.AnagramGroups.anagramGroups;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AnagramGroupsTest {

  @Test
  public void test() {
    String[] input = {"tea", "ate", "tab", "eta", "bat"};
    String[][] result = anagramGroups(input);

    String[][] expected = {new String[] {"ate", "tea", "eta"}, new String[] {"tab", "bat"}};

    // TODO assertion is failing because the order of the internal array elements
    assertThat(result).isDeepEqualTo(expected);
  }
}
