package strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LongestStringWith2UniqueChars {

	public static void main(String[] args) {
		String s = "abcdabcabefgcabb";
		String sub = findLongestString(s);
		System.out.println("Longest substring is : " + sub);
	}

	private static String findLongestString(String str) {
		String sub = "";
		StringBuffer sb = new StringBuffer();
		int max = 0;
		char[] sarray = str.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		char c;
		for (int i = 0; i < str.length(); i++) {
			c = sarray[i];
			if (map.size() < 2 && map.get(c) == null) {
				map.put(c, i);
//				sb.append(c);
			} else {
				if (map.get(c) != null) {
//					sb.append(c);
				} else {
					int tmp = -1;
					char tmpChar = 'a';
					for (Entry<Character, Integer> entry : map.entrySet()) {
						if (entry.getValue() > tmp) {
							tmp = entry.getValue();
							tmpChar = entry.getKey();
						}
					}
					char ch = 'a';
					for (Entry<Character, Integer> entry : map.entrySet()) {
						if (!entry.getKey().equals(tmpChar)) {
							ch = entry.getKey();
						}
					}
					map.remove(ch);
					if (sb.length() > max) {
						max = sb.length();
						sub = sb.toString();
					}
					sb.delete(0, sb.length());
					for (int j = tmp; j < i; j++) {
						sb.append(sarray[j]);
					}
					map.put(c, i);
				}
			}
			sb.append(c);
		}
		if (sb.length() > max) {
			max = sb.length();
			sub = sb.toString();
		}
		return sub;
	}
}
