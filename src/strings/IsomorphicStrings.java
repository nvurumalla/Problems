package strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public static void main(String[] args) {
		String a = "google";
		String b = "baabee";
		boolean flag = isIsomorphic(a, b);
		System.out.println("Are the strings isomorphic?  " + flag);

	}

	private static boolean isIsomorphic(String a, String b) {
		char[] arr1 = a.toCharArray();
		char[] arr2 = b.toCharArray();
		Map<Character, Character> map = new HashMap<Character, Character>();

		if (a.length() != b.length()) {
			return false;
		}
		for (int i = 0; i < a.length(); i++) {
			if (map.containsKey(arr1[i])) {
				if (!map.get(arr1[i]).equals(arr2[i])) {
					return false;
				}
			} else {
				if (map.containsValue(arr2[i])) {
					return false;
				}
				map.put(arr1[i], arr2[i]);
			}
 		}
		return true;
	}

}
