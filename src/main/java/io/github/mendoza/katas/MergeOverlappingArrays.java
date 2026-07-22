package io.github.mendoza.katas;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of intervals, merge the overlapping ones.
 *
 * <p>Input: [[1,3],[2,6],[8,10],[11,15]] Output: [[1,6],[8,10],[11,15]]
 *
 * <p>Input: [[1,4],[0,4]] Output: [[0,4]]
 *
 * <p>Input: [[1,4],[8,10],[0,4]]
 */
public class MergeOverlappingArrays {

  public static int[][] mergeOverlapping(int[][] input) {

    Arrays.sort(input, (a, b) -> Integer.compare(a[0], b[0]));

    int[] latestInterval = input[0];
    ArrayList<int[]> merged = new ArrayList<>();
    merged.add(latestInterval);

    for (int i = 1; i < input.length; i++) {
      int currentStart = input[i][0];
      int currentEnd = input[i][1];
      int latestStart = latestInterval[0];
      int latestEnd = latestInterval[1];

      if (currentStart <= latestEnd) {
        // there's an overlap
        latestInterval[0] = Math.min(currentStart, latestStart);
        latestInterval[1] = Math.max(currentEnd, latestEnd);
      } else {
        latestInterval = input[i];
        merged.add(latestInterval);
      }
    }

    return merged.toArray(new int[merged.size()][]);
  }
}
