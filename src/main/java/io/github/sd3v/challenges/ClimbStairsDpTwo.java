package io.github.sd3v.challenges;

// Improved solution using DP
public class ClimbStairsDpTwo {

    public static int climbStairs(int stairs) {
        var s = new int[stairs + 1];

        s[1] = 1;
        s[2] = 2;

        for (int i = 3; i <= stairs; i++) {
            s[i] = s[i - 1] + s[i - 2];
        }

        return s[stairs];
    }
}
