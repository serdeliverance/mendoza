package io.github.mendoza.aoc2024.day01;

import java.util.Arrays;

public class Day01Part1 {

  public static int solutionPart1(int[] listOne, int[] listTwo) {
    Arrays.sort(listOne);
    Arrays.sort(listTwo);
    int result = 0;
    for (int i = 0; i < listOne.length; i++) {
      result += Math.abs(listOne[i] - listTwo[i]);
    }
    return result;
  }
}
