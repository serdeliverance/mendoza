package io.github.mendoza.katas;

/*
*
* Expand string according to the number before square brackets.
* Numbers are not necessarily single digits
*
* Input:
* 2[ab]3[c]1[d]

* Output:
* ababcccd
*
*/

import java.util.Stack;

// TODO solve it using stringTokenizer
// TODO solve it using regex
// TODO understand why the provided solution is not optimal (the one that concatenates string)
// it has something to do with creating String each time, instead of using StringBuilder (string
// pool)
public class ExpandString {

  /** Solution without using auxiliary DS, just traversing the string with while loops */
  public static String expandString(String input) {
    int index = 0;
    StringBuilder sb = new StringBuilder();

    while (index < input.length()) {
      StringBuilder factorSb = new StringBuilder();
      while (Character.isDigit(input.charAt(index))) {
        factorSb.append(input.charAt(index));
        index++;
      }

      index++;

      StringBuilder termSb = new StringBuilder();
      while (Character.isLetter(input.charAt(index))) {
        termSb.append(input.charAt(index));
        index++;
      }

      int factor = Integer.parseInt(factorSb.toString());
      String term = termSb.toString();

      sb.repeat(term, factor);

      index++;
    }

    return sb.toString();
  }

  /**
   * My first attempt
   *
   * <p>This solution uses a stack for stacking read it stops at terminal tokens ([ or ]) and
   * unstack it builds terms or factor depending on the terminal token and uses a string builder for
   * creating the final string.
   */
  public static String expandString_mine(String input) {

    StringBuilder sb = new StringBuilder();
    Stack<Character> stack = new Stack<>();

    int multiplier = 0;
    String term;

    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);

      switch (c) {
        case '[':
          multiplier = Integer.parseInt(unstack(stack));
          break;
        case ']':
          term = unstack(stack);
          expandTermByMultiplier(term, multiplier, sb);
          break;
        default:
          stack.add(c);
          break;
      }
    }

    return sb.toString();
  }

  private static String unstack(Stack<Character> stack) {
    StringBuilder sb = new StringBuilder();

    while (!stack.empty()) {
      sb.append(stack.pop());
    }

    return sb.reverse().toString();
  }

  private static void expandTermByMultiplier(String term, int multiplier, StringBuilder sb) {
    if (multiplier == 0) {
      return;
    }
    sb.repeat(term, multiplier);
  }
}
