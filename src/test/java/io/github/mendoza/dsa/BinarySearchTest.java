package io.github.mendoza.dsa;

import org.junit.jupiter.api.Test;

import static io.github.mendoza.dsa.BinarySearch.binarySearch;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    public void whenItemIsFound() {
        int[] list = { 1, 2, 5, 7, 9, 13};
        int result = binarySearch(list, 7);
        assertEquals(3, result);
    }

    @Test
    public void whenItemNotFound() {
        int[] list = { 1, 2, 5, 7, 9, 13};
        int result = binarySearch(list, 8);
        assertEquals(-1, result);
    }
}