package strings;

public class ReverseVowels {

	public static void main(String[] args) {
		String str = "hawaii";
		String revStr = reverse(str);

		System.out.println("Reversed String : " + revStr);
	}

	private static String reverse(String str) {
		char[] ca = str.toCharArray();
		int i = 0, j = ca.length-1;
		while (i <= j) {
			char c1 = ca[i];
			char c2 = ca[j];
			boolean flag1 = false;
			boolean flag2 = false;

			if (c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') {
				flag1 = true;
			} else {
				i++;
			}
			if (c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u') {
				flag2 = true;
			} else {
				j--;
			}

			if (flag1 && flag2) {
				ca[i] = c2;
				ca[j] = c1;
				i++;
				j--;
			}
		}

		return String.copyValueOf(ca);
	}

}
