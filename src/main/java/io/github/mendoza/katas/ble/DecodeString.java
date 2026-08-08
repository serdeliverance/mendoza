package io.github.mendoza.katas.ble;

import java.util.Stack;

public class DecodeString {

    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;

        while (i < s.length()) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                // pop all elements of the stack until the next '['
                Character current = stack.pop();
                StringBuilder sb = new StringBuilder();
                while (current != '[') {
                    sb.append(current);
                    current = stack.pop();
                }
                int factor = Integer.parseInt(Character.toString(stack.pop()));
                String resolvedExpression = sb.reverse().toString().repeat(factor);
                for (Character c : resolvedExpression.toCharArray()) {
                    stack.push(c);
                }
            }
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
           sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
