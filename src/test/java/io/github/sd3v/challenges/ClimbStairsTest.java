package io.github.sd3v.challenges;

import static io.github.sd3v.challenges.ClimbStairs.climbStairs;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClimbStairsTest {

  @Test
  public void scenario1() {
    var result = climbStairs(2);

    assertEquals(2, result);
  }

  @Test
  public void scenario2() {
    var result = climbStairs(3);

    assertEquals(3, result);
  }

  @Test
  public void scenario3() {
    var result = climbStairs(4);

    assertEquals(5, result);
  }
}
