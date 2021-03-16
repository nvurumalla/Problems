package strings;

import stacksAndQueues.StackString;

import java.util.Objects;
import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "100[l]";
        System.out.println("Decoded String: " + decodeString(s));
    }

    private static String decodeString(String s) {
        if (s.isEmpty() || s.isEmpty()) {
            return s;
        }
        if (Objects.isNull(s)) {
            return null;
        }
        char[] c = s.toCharArray();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(c[i])) {
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(c[i])) {
                    sb.append(c[i]);
                    i++;
                }
                i--;
                stack.push(sb.toString());
                continue;
            }
            if (c[i] != ']') {
                stack.push(String.valueOf(c[i]));
                continue;
            }

            String ch;
            String tmp = "";
            while (!stack.peek().equals("[")) {
                ch = stack.pop();
                tmp = tmp + ch;
            }
            stack.pop();
            ch = stack.pop();
            String concat = "";
            for (int j = 1; j <= Integer.valueOf(ch); j++) {
                concat = concat + tmp;
            }
            stack.push(concat);

        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();
    }
}
