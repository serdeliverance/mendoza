package io.github.mendoza.misc;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean validParenthesis(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        int i = 0;
        while (i < chars.length) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else if (isClosingElement(stack, chars[i])) {
                    stack.pop();
            } else {
                // invalid expression
                return false;
            }
            i++;
        }

        return stack.isEmpty() && i == chars.length;
    }

    private static boolean isClosingElement(Stack<Character> stack, char aChar) {
        char topElement = stack.peek();
        return topElement == '('  && aChar == ')' || topElement == '[' && aChar == ']' || topElement == '{' && aChar == '}';
    }
}
