package io.github.sd3v.challenges;

import java.util.HashMap;

public class SumTwo {

  public static int[] sumTwo(int[] arr, int target) {
    var numMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
      var sumTwoNumber = target - arr[i];
      var sumTwoIndex = numMap.get(sumTwoNumber);
      if (sumTwoIndex != null) {
        if (arr[i] > arr[sumTwoIndex]) {
          return new int[] {sumTwoIndex + 1, i + 1};
        } else {
          return new int[] {i + 1, sumTwoIndex + 1};
        }
      } else {
        numMap.put(arr[i], i);
      }
    }
    return new int[] {-1, -1};
  }
}
