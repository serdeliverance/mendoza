package io.github.mendoza.katas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class KMostFrequentTest {

  @Test
  public void test() {
    int[] input = new int[] {1, 1, 1, 1, 2, 2, 5, 5, 5, 3, 4};
    int[] result = KMostFrequent.solution(input, 2);

    assertThat(result).containsExactly(1, 5);
  }

  @Test
  public void test_1() {
    int[] input = new int[] {1, 1, 1, 2, 2, 3};
    int[] result = KMostFrequent.solution(input, 2);

    assertThat(result).containsExactly(1, 2);
  }

  @Test
  public void test_2() {
    int[] input = new int[] {1};
    int[] result = KMostFrequent.solution(input, 1);

    assertThat(result).containsExactly(1);
  }

  @Test
  public void test_3() {
    int[] input = new int[] {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
    int[] result = KMostFrequent.solution(input, 2);

    assertThat(result).containsExactly(1, 2);
  }
}
