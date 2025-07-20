package io.github.mendoza.misc;

public class PivotIndex {

    public static int pivotIndex(int[] arr) {
        int leftSum = 0;
        int rightSum = totalSum(arr);
        int i = 0;
        while (i < arr.length) {
            rightSum -= arr[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += arr[i];
            i++;
        }
        return -1;
    }

    private static int totalSum(int[] arr) {
        int total = 0;
        for (int i : arr) {
            total += i;
        }
        return total;
    }
}
