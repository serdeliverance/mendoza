package io.github.sd3v.ctci.exercises;

import java.util.Arrays;

public class IsPermutation {

    // Complexity: 2logN + 4N
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length() || s1.length() == 0) {
            return false;
        }

        var s1Sorted = sortString(s1);
        var s2Sorted = sortString(s2);


        for (int i = 0; i < s1.length(); i++) {
            if (s1Sorted.charAt(i) != s2Sorted.charAt(i)) {
                return false;
            }
        }

        var areSameString = true;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                areSameString = false;
            }
        }

        return !areSameString;
    }

    private static String sortString(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
}
