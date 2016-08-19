package arrays;

public class RotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {6,9,10,11,1,2};
		int index = find(arr, 11);
		System.out.println(index);

	}

	private static int find(int[] a, int el) {
		int h = a.length-1;
		int l = 0;
		int m = (l+h)/2;
		int index = -1;

		while (l<=h) {
			if (el < a[m]) {
				if (a[m] > a[h]) {
					if (el <= a[h]) {
						l = m+1;
					} else {
						h = m-1;
					}
				} else if (a[m] < a[h]) {
					h = m-1;
				}
			} else if (el > a[m] && a[m] > a[l]) {
				l = m+1;
			} else if (el > a[m] && a[m] < a[l]) {
				l = m+1;
			} else if (el == a[m]){
				index = m;
				break;
			}
			m = (l+h)/2;
		}
		return index;
	}
}
