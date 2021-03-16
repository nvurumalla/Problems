package strings;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class ValidParanthesis1 {
    static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c=='(' || c == '{' || c == '[') {
                stack.push(s.charAt(i));
            }
            else if (!map.get(c).equals(stack.pop())) {
                return false;
            }
        }

        return stack.empty();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;

//        sum = addNumbers(a, b);
//        System.out.println(sum);
    }
}
