package io.github.mendoza.aoc2024.day01;

import java.util.HashMap;

public class Day01Part2 {

    public static int solutionPart2(int[] listA, int[] listB) {
        // creating occurrences map
        var occurrencesMap = new HashMap<Integer, Integer>();
        for (int i : listB) {
            // we can replace all this boilerplate using Map::merge method
            var ocurrence = occurrencesMap.get(i);
            if (ocurrence != null) {
                occurrencesMap.put(i, ocurrence + 1);
            } else {
                occurrencesMap.put(i, 1);
            }
        }

        // iterating over listA and calculating the frequency (value * occurrence)
        int result = 0;
        for (int i : listA) {
            var occurrence = occurrencesMap.get(i);
            if (occurrence != null) {
                result += i * occurrence;
            }
        }

        return result;
    }
}
