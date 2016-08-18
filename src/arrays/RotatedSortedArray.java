package arrays;

public class RotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {6,9,10,11,1,2};
		find(arr, 5);

	}

	private static int find(int[] arr, int el) {
		int h = arr.length-1;
		int l = 0;
		int m = (l+h)/2;

		while (l<=h) {
			if (arr[m] < arr[m+1] && arr[m] > arr[m-1]) {
				if (el > arr[m]) {
					l = m-1;
					continue;
				} else if (el > arr[m]) {
					h = m+1;
				} else {
					return m;
				}
			} else if (arr[m] < arr[m-1]) {
				return arr[m];
			}
		}
		return -1;
	}
}
