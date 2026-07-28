package io.github.mendoza.katas;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

  public static int solution(String s) {
    if (s.length() <= 1) {
      return s.length();
    }

    Set<Character> charSet = new HashSet<>();
    int maxLength = Integer.MIN_VALUE;
    int i = 0;

    for (int j = 0; j < s.length(); j++) {
      if (charSet.contains(s.charAt(j))) {
        maxLength = Math.max(maxLength, j - i);
        while (charSet.contains(s.charAt(j))) {
          charSet.remove(s.charAt(i));
          i++;
        }
      }

      charSet.add(s.charAt(j));
    }

    return Math.max(maxLength, s.length() - i);
  }
}
