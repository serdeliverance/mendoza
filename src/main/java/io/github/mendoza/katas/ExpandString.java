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

public class ExpandString {

    public static void main(String[] args) {
        String input = new String("2[ab]3[c]1[d]");
        String expandedString = expandString(input);
        System.out.println("The expanded string is: " + expandedString);
    }

    public static String expandString(String input) {

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
                    String stringPart = expandTermByMultiplier(term, multiplier);
                    sb.append(stringPart);
                    multiplier = 0;
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

        while(!stack.empty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    private static String expandTermByMultiplier(String term, int multiplier) {
        if (multiplier == 0) {
            return "";
        }

        if (multiplier == 1) {
            return term;
        }

        StringBuilder sb = new StringBuilder();

        return sb.repeat(term, multiplier).toString();
    }
}
