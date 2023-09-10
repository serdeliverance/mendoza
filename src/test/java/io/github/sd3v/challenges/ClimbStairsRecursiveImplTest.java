package io.github.sd3v.challenges;

import org.junit.jupiter.api.Test;

import static io.github.sd3v.challenges.ClimbStairsDpOne.climbStairs;
import static org.junit.jupiter.api.Assertions.*;

class ClimbStairsRecursiveImplTest {
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

    @Test
    public void scenarioLargeInput() {
        var result = climbStairs(30);

        assertEquals(1346269, result);
    }
}