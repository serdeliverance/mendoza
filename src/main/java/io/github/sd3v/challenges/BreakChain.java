package io.github.sd3v.challenges;

public class BreakChain {

    public static int solution(int[] arr) {
        // P > 0 and Q < N - 1
        var min = Integer.MAX_VALUE;
        for (int p = 1; p < arr.length - 3; p++) {
            for (int q = p + 2; q < arr.length - 1;q++) {
                var newMin = arr[p] + arr[q];
                if (newMin < min) {
                    min = newMin;
                }
            }
        }
        return min;
    }
}
