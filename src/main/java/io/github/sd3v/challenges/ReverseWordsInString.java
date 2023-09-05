package io.github.sd3v.challenges;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        var wordStack = new Stack<String>();
        Queue<Character> charQueue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            // TODO check first case
            if (s.charAt(i) == ' ') {
                if (i - 1 < 0 || s.charAt(i - 1) == ' ') {
                    // DO nothing
                }
                else {
                    var newWord = dequeAll(charQueue);
                    wordStack.add(newWord);
                }
            } else {
                charQueue.offer(s.charAt(i));
            }
        }

        if (!charQueue.isEmpty()) {
            var newWord = dequeAll(charQueue);
            wordStack.add(newWord);
        }

        return buildReversedWords(wordStack);
    }

    private static String buildReversedWords(Stack<String> wordStack) {
        var sb = new StringBuilder();
        while (!wordStack.empty()) {
            if (!sb.isEmpty()) {
                sb.append(" ");
            }
            sb.append(wordStack.pop());
        }
        return sb.toString();
    }

    private static String dequeAll(Queue<Character> charQueue) {
        var sb = new StringBuilder();
        while(!charQueue.isEmpty()) {
            sb.append(charQueue.remove());
        }
        return sb.toString();
    }
}
