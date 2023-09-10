package io.github.sd3v.challenges;

// Recursive solution. Time complexity: O(n ** 2)
public class ClimbStairsRecursiveImpl {

  public static int climbStairs(int stairs) {
    if (stairs == 1) {
      return 1;
    } else if (stairs == 2) {
      return 2;
    }
    return climbStairs(stairs - 1) + climbStairs(stairs - 2);
  }
}
