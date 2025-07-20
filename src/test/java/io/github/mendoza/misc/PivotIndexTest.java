package io.github.mendoza.misc;

import org.junit.jupiter.api.Test;

import static io.github.mendoza.misc.PivotIndex.pivotIndex;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PivotIndexTest {

    @Test
    public void test1() {
        int[] arr = new int[] {5, 6, 7, 2, 2, 7};
        int result = pivotIndex(arr);
        assertEquals(2, result);
    }

    @Test
    public void test2() {
        int[] arr = new int[] {0, 0, 0, 0};
        int result = pivotIndex(arr);
        assertEquals(0, result);
    }

    @Test
    public void test3_not_found() {
        int[] arr = new int[] {5, 6, 7, 5, 2, 7};
        int result = pivotIndex(arr);
        assertEquals(-1, result);
    }
}