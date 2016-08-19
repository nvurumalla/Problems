package arrays;

public class MaxProductSubArray {

	public static void main(String[] args) {
		int[] input = {-2,-3,-1,4};
		int max = findMax(input);
		System.out.println("Max number is : " + max);
	}

	private static int findMax(int[] a) {
		int maxSoFar = a[0];
		int minSoFar = a[0];
		int max = a[0];
		int prevMax = a[0];
		int bMaxSoFar = 0;
		int eMaxSoFar = 0;
		int bMinSoFar = 0;
//		int eMinSoFar = 0;
		int b = 0;
		int e = 0;


		for (int i = 1; i<a.length; i++) {
			prevMax = maxSoFar;
			maxSoFar = Math.max(Math.max(maxSoFar*a[i], a[i]), a[i]*minSoFar);
			if (maxSoFar == a[i]) {
				bMaxSoFar = i;
				eMaxSoFar = i;
			} else if (maxSoFar == prevMax*a[i]) {
				eMaxSoFar = i;
			} else {
				bMaxSoFar = bMinSoFar;
				eMaxSoFar = i;
			}
			minSoFar = Math.min(Math.min(minSoFar*a[i], a[i]), prevMax*a[i]);
			if (minSoFar == a[i]) {
				bMinSoFar = i;
//				eMinSoFar = i;
			} else if (minSoFar == minSoFar*a[i]) {
//				eMinSoFar = i;
			} else {
				bMinSoFar = bMaxSoFar;
//				eMinSoFar = i;
			}
			max = Math.max(max, maxSoFar);
			if (max == maxSoFar) {
				b = bMaxSoFar;
				e = eMaxSoFar;
			}
		}

		System.out.println(b);
		System.out.println(e);

		return max;
	}
}
