package io.github.sd3v.challenges;

import org.junit.jupiter.api.Test;

import static io.github.sd3v.challenges.BreakChain.solution;
import static org.junit.jupiter.api.Assertions.*;

class BreakChainTest {

    @Test
    public void testBaseScenario() {
        var input = new int[] {5, 2, 4, 6 ,3 ,7};
        var result = solution(input);

        assertEquals(5, result);
    }
}