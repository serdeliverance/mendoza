package io.github.sd3v.challenges;

public class FindIndexFirstOccurrenceString {

  // Time complexity = O(m*n)
  public static int findIndexFirstOccurrenceString(String str1, String str2) {
    for (int i = 0; i < str2.length() - str1.length() + 1; i++) {
      if (str2.charAt(i) == str1.charAt(0)) {
        if (substringMatch(str2, i, str1)) {
          return i;
        }
      }
    }
    return -1;
  }

  private static boolean substringMatch(String str2, int i, String str1) {
    var substr = str2.substring(i, i + str1.length());
    return substr.equals(str1);
  }
}
