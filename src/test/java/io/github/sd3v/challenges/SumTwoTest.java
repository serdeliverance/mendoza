package io.github.sd3v.challenges;

import org.junit.jupiter.api.Test;

import static io.github.sd3v.challenges.SumTwo.sumTwo;
import static org.junit.jupiter.api.Assertions.*;

class SumTwoTest {

    @Test
    public void scenario1() {
        var arr = new int[] { 2, 7, 11, 15};
        var result = sumTwo(arr, 9);

        assertArrayEquals(new int[] {1, 2}, result);
    }

    @Test
    public void scenario2() {
        var arr = new int[] { 2, 3, 4 };
        var result = sumTwo(arr, 6);

        assertArrayEquals(new int[] {1, 3}, result);
    }

    @Test
    public void scenario3() {
        var arr = new int[] { -1, 0};
        var result = sumTwo(arr, -1);

        assertArrayEquals(new int[] {1, 2}, result);
    }
}