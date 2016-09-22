package arrays;

public class ArrayRotation {

	public static void main(String[] args) {

		int[] a = {1};
		rotateArray(a, 3);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void rotateArray(int[] a, int k) {
		int tmp2;

		if (a.length == k || a.length == 0 || a.length == 1) {
			return;
		} else if (a.length < k) {
			k = k % a.length;
		}

		int i = 0;
		int j = a.length - k - 1;
		while (i<=j) {
			tmp2 = a[i];
			a[i] = a[j];
			a[j] = tmp2;
			i++;
			j--;
		}
		for (int x = 0; x < a.length; x++) {
			System.out.print(a[x] + " ");
		}
		System.out.println();

		i = a.length - k;
		j = a.length - 1;
		while (i<=j) {
			tmp2 = a[i];
			a[i] = a[j];
			a[j] = tmp2;
			i++;
			j--;
		}
		for (int x = 0; x < a.length; x++) {
			System.out.print(a[x] + " ");
		}
		System.out.println();

		i = 0;
		j = a.length - 1;
		while (i<=j) {
			tmp2 = a[i];
			a[i] = a[j];
			a[j] = tmp2;
			i++;
			j--;
		}
	}

}
