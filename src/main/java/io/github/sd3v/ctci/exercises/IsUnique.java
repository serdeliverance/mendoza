package io.github.sd3v.ctci.exercises;

import java.util.HashMap;

public class IsUnique {

    public static boolean isUnique(String s) {
        return solution2(s);
    }

    // solution 1: using auxiliar data structure
    public static boolean solution1(String s) {
        var auxMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            var k = Character.getNumericValue(c);
            var exists = auxMap.get(k);
            if (exists != null) {
                return false;
            }
            auxMap.put(k, k);
        }
        return true;
    }

    // solution 2: no auxiliar ds
    public static boolean solution2(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length() -1; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
