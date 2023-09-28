package io.github.sd3v.dsa;

public class BinarySearch {

    public static boolean binarySearch(int[] arr, int value) {
        int lo = 0;
        int hi = arr.length;

        do {
            int m = lo + (hi - lo)/2;
            int medium = arr[m];

            if (value == medium) {
                return true;
            } else if (medium > value) {
                hi = m;
            } else {
                lo = m + 1;
            }

        } while (lo < hi);

        return false;
    }
}
