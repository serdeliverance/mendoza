package io.github.sd3v.challenges;

import java.util.HashMap;
import java.util.Map;

// This implementation uses dynamic programming
public class ClimbStairsDpOne {

    public static int climbStairs(int stairs) {
        return calculateCombinations(stairs, new HashMap<>());
    }

    public static int calculateCombinations(int stairs, Map<Integer, Integer> cache) {
        if (stairs == 1) {
            return 1;
        } else if (stairs == 2) {
            return 2;
        }

        var combinationsBranchLeft = getCombinationsFromCache(stairs - 1, cache);
        var combinationsBranchRight = getCombinationsFromCache(stairs - 2, cache);

        return combinationsBranchLeft + combinationsBranchRight;
    }

    private static int getCombinationsFromCache(int remainingStairs, Map<Integer, Integer> cache) {
        var combinations = cache.get(remainingStairs);
        if (combinations == null) {
            combinations = calculateCombinations(remainingStairs, cache);
            cache.put(remainingStairs, combinations);
            return combinations;
        }
        return combinations;
    }
}
