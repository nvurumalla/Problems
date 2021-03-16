package strings;

import java.util.Stack;

/**
 * Reverse Words in a String
 * Clean code handbook problem:6
 */
public class ReverseWords {
    public String reverse(String s) {
        Stack<String> wordStack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(i) == ' ') {
                wordStack.push(sb.toString());
                if (sb.length() != 0) {
                    sb = new StringBuilder();
                    continue;
                }
            }
            sb.append(s.indexOf(i));
        }

        sb = new StringBuilder();
        while (!wordStack.isEmpty()) {
            sb.append(' ');
            sb.append(wordStack.pop());
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }

    public String reverseSolution(String s) {
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s.substring(i, j));
            }
        }
        return reversed.toString();
    }
}
