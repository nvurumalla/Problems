package strings;

import stacksAndQueues.Stack;

public class ValidParanthesis {

	public static void main(String[] args) {
		String str = "(){[]}{[()]}";
		boolean isValid = isValid(str);
		System.out.println("Is the string valid ?  " + isValid);
	}

	private static boolean isValid(String s) {
		boolean flag = true;
		char c[] = s.toCharArray();
		Stack stack = new Stack();
		for(int i=0; i<c.length; i++) {
			if (c[i]=='(' || c[i]=='[' || c[i]=='{') {
				stack.push(c[i]);
			} else {
				char ch = stack.pop();
				if (ch == '$') {
					flag = false;
					break;
				} else if ((c[i] == ')' && ch != '(') || (c[i] == ']' && ch != '[') || (c[i] == '}' && ch != '{')) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}

}
