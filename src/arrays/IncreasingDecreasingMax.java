package arrays;

public class IncreasingDecreasingMax {

	public static void main(String[] args) {
		int[] input = {1,2,6,14,3};
		int max = findMax(input);
		if (max == 0) {

		}
		System.out.println("Max number is : " + max);
	}

	private static int findMax(int[] input) {
		int l = 0;
		int h = input.length - 1;
		int m = (l+h)/2;
		while (l <= h) {
			if (m == 0 && input[m] > input[m+1]) {
				return input[m];
			}
			if (input[m] < input[m-1]) {
				h = m-1;
				m = (l+h)/2;
			} else {
				if(m == input.length-1) {
					return input[m];
				} else if ((m+1 < input.length) && (input[m] > input[m+1])) {
					return input[m];
				} else {
					l = m+1;
					m = (l+h)/2;
				}
			}
		}
		return 0;
	}
}
