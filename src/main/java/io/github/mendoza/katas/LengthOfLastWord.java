package io.github.mendoza.katas;

/**
 * Given a string with words. Returnt the length of the latest word
 *
 * <p>Input "today I went to the office"
 *
 * <p>Output: 6 (because of office has 6 letters)
 */
public class LengthOfLastWord {

  /**
   * Nested while loops, going char by char and using a string builder.
   *
   * <p>Cons: we need the last word and we are unnecessary iterating from the very beginning.
   */
  public static int solution(String s) {
    String input = s.trim();
    String latestWord = "";

    int i = 0;

    while (i < input.length()) {
      if (Character.isLetter(input.charAt(i))) {
        // TODO improvement: we don't need the StringBuilder, we can just return the length
        StringBuilder sb = new StringBuilder();

        while (i < input.length() && Character.isLetter(input.charAt(i))) {
          sb.append(input.charAt(i));
          i++;
        }
        latestWord = sb.toString();
      } else {
        while (i < input.length() && !Character.isLetter(input.charAt(i))) {
          // if not a letter, we skip
          i++;
        }
      }
    }

    return latestWord.length();
  }

  /** Solution using String methods (the easiest one) */
  public static int solution_2(String s) {
    String[] parts = s.trim().split(" ");
    return parts.length > 0 ? parts[parts.length - 1].length() : 0;
  }

  /**
   * Reading starting from the end of the string.
   *
   * <p>It is most efficient than reading from the beginning.
   */
  public static int solution_3(String input) {
    if (input.isEmpty()) {
      return 0;
    }

    int i = input.length() - 1;

    while (i >= 0) {
      if (Character.isLetter(input.charAt(i))) {
        int latestWordLength = 0;
        while (i >= 0 && Character.isLetter(input.charAt(i))) {
          i--;
          latestWordLength++;
        }
        return latestWordLength;
      } else {
        i--;
      }
    }

    return 0;
  }
}
