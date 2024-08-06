package io.github.mendoza.dsa;

import java.util.ArrayList;

public class BinarySearch {

    public static int binarySearch(int[] items, int item) {
        int low = 0;
        int high = items.length -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int guess = items[mid];

            if (guess < item) {
                low = mid + 1;
            } else if (guess > item) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
