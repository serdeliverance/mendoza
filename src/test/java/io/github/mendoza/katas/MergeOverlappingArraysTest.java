package io.github.mendoza.katas;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.atIndex;

import org.junit.jupiter.api.Test;

class MergeOverlappingArraysTest {

  @Test
  public void test() {
    int[][] input = {{1, 3}, {2, 6}, {8, 10}, {11, 15}};
    int[][] result = MergeOverlappingArrays.mergeOverlapping(input);

    // Expected [[1,6],[8,10],[11,15]]
    // TODO improve this assertion (if possible)
    assertThat(result)
        .contains(new int[] {1, 6}, atIndex(0))
        .contains(new int[] {8, 10}, atIndex(1))
        .contains(new int[] {11, 15}, atIndex(2));
  }
}
