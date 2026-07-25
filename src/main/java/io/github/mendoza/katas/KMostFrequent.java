package io.github.mendoza.katas;

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

    /**
     * Time = O(n log n)
     * Space = O(n)
     *
     */
  public static int[] solution(int[] input, int k) {
    Map<Integer, Integer> numberFrequencyMap = new HashMap<>();

    for (int i = 0; i < input.length; i++) {
      numberFrequencyMap.merge(input[i], 1, Integer::sum);
    }

    return numberFrequencyMap.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .limit(k)
            .mapToInt(Map.Entry::getKey)
            .toArray();
  }
}
