package strings;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "abcdabcabefgcabb";
		String sub = findLongestSubString(s);
		System.out.println("Longest substring is : " + sub);
	}

	private static String findLongestSubString(String s) {
		String sub = "";
		StringBuffer sb = new StringBuffer();
		int max = 0;
		char[] sarray = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (map.get(sarray[i]) == null) {
				map.put(sarray[i], i);
				sb.append(sarray[i]);
			} else {
				if (sb.length() > max) {
					sub = sb.toString();
					max = sb.length();
				}
				i = map.get(sarray[i]) + 1;
				sb.delete(0, sb.length());
				sb.append(sarray[i]);
				map.clear();
				map.put(sarray[i], i);
			}
		}
		return sub;

	}
}
