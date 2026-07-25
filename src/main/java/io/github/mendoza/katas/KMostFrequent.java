package io.github.mendoza.katas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of numbers and a number k, return the most frequent k elements
 *
 * <p>Input [1,1,1,1,2,2,5,5,5,3,4] and k = 2
 *
 * <p>Output [1, 5]
 */
public class KMostFrequent {

  public static int[] solution(int[] input, int k) {
    if (input.length == 0) {
      return new int[] {};
    }

    int[] sortedInput = Arrays.stream(input).boxed().sorted().mapToInt(Integer::intValue).toArray();

    Map<Integer, Integer> numberFrequencyMap = new HashMap<>();

    int prev = sortedInput[0];
    int i = 0;
    int frequency = 0;

    numberFrequencyMap.put(prev, frequency);

    while (i < sortedInput.length) {
      if (prev != sortedInput[i]) {
        frequency = 0;
        prev = sortedInput[i];
        numberFrequencyMap.put(prev, frequency);
      }

      frequency++;
      numberFrequencyMap.replace(prev, frequency - 1, frequency);
      i++;
    }

    int[] kMostFrequent =
        numberFrequencyMap.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();

    return kMostFrequent;
  }
}
