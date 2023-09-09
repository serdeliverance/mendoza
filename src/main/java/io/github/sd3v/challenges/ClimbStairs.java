package io.github.sd3v.challenges;

public class ClimbStairs {

  // Recursion impl
  public static int climbStairs(int stairs) {
    if (stairs == 1) {
      return 1;
    } else if (stairs == 2) {
      return 2;
    }
    return climbStairs(stairs - 1) + climbStairs(stairs - 2);
  }
}
