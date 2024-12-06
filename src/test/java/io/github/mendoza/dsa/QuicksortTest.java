package io.github.mendoza.dsa;

import static io.github.mendoza.dsa.Quicksort.quicksort;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuicksortTest {

  @Test
  public void emptyArrayShouldReturnEmptyArray() {
    int[] arr = {};
    quicksort(arr);
    assertEquals(0, arr.length);
  }

  @Test
  public void arrayOfSizeOneShouldReturnArray() {
    int[] arr = {1};
    quicksort(arr);
    int[] expected = new int[] {1};
    assertArrayEquals(expected, arr);
  }

  @Test
  public void arrayOfMoreThanTwoElementsShouldBeSorted() {
    int[] arr = {3, 4, 1, 2, 7, 10, 8};
    quicksort(arr);
    int[] expected = new int[] {1, 2, 3, 4, 7, 8, 10};
    assertArrayEquals(expected, arr);
  }
}
