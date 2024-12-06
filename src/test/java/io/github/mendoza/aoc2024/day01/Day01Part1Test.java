package io.github.mendoza.aoc2024.day01;

import static io.github.mendoza.aoc2024.day01.Day01Part1.solutionPart1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Day01Part1Test {

  @Test
  public void testExample() {
    int[] arr1 = {3, 4, 2, 1, 3, 3};
    int[] arr2 = {4, 3, 5, 3, 9, 3};

    int result = solutionPart1(arr1, arr2);

    assertEquals(11, result);
  }
}
