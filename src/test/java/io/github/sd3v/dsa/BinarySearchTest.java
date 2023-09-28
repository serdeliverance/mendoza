package io.github.sd3v.dsa;

import org.junit.jupiter.api.Test;

import static io.github.sd3v.dsa.BinarySearch.binarySearch;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    public void shouldFindElement() {
        var result = binarySearch(new int[] {1, 4, 5, 6, 8, 9}, 8);

        assertTrue(result);
    }

    @Test
    public void shouldNotFindElement() {
        var result = binarySearch(new int[] {1, 4, 5, 6, 8, 9}, 7);

        assertFalse(result);
    }
}