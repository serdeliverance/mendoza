package io.github.sd3v.challenges;

import static io.github.sd3v.challenges.BreakChain.solution;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BreakChainTest {

  @Test
  public void testBaseScenario() {
    var input = new int[] {5, 2, 4, 6, 3, 7};
    var result = solution(input);

    assertEquals(5, result);
  }
}
