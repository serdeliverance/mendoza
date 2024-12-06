package io.github.mendoza.dsa;

public class Quicksort {

  public static int partition(int[] arr, int start, int end) {
    int pivot = arr[end];
    int i = start - 1;

    for (int j = start; j <= end; j++) {
      if (arr[j] < pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    i++;
    int temp = arr[i];
    arr[i] = arr[end];
    arr[end] = temp;
    return i;
  }

  public static void quicksort(int[] arr, int low, int high) {
    if (low < high) {
      int pivot = partition(arr, low, high);
      quicksort(arr, low, pivot - 1);
      quicksort(arr, pivot + 1, high);
    }
  }

  public static void quicksort(int[] arr) {
    quicksort(arr, 0, arr.length - 1);
  }
}
