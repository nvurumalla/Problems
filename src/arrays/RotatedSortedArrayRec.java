package arrays;

public class RotatedSortedArrayRec {

    public static void main(String[] args) {
        int[] arr = {6, 9, 10, 11, 1, 2};
        int index = find(arr, 11, 0, arr.length - 1);
        System.out.println(index);
    }

    private static int find(int[] a, int el, int l, int h) {
        int m = (l + h) / 2;
        int index = -1;

        if (l == h && a[l] != el) {
            return -1;
        }
        if (a[m] == el) {
            return m;
        }

        if ((a[l] < el && el < a[m]) || (a[l] > a[m] && (el < a[m] || el > a[l]))) {
            index = find(a, el, l, m);
        }

        if (el < a[l] && a[l] < a[m]) {
            return -1;
        } else if (a[l] < el && el < a[m])


            if (a[l] > a[h] && el < a[h]) {
                index = find(a, el, l, m);
                index = find(a, el, m, h);

            }
        if (a[l] < a[h]) {

        }

        while (l <= h) {
            if (el < a[m]) {
                if (a[m] > a[h]) {
                    if (el <= a[h]) {
                        l = m + 1;
                    } else {
                        h = m - 1;
                    }
                } else if (a[m] < a[h]) {
                    h = m - 1;
                }
            } else if (el > a[m] && a[m] > a[l]) {
                l = m + 1;
            } else if (el > a[m] && a[m] < a[l]) {
                l = m + 1;
            } else if (el == a[m]) {
                index = m;
                break;
            }
            m = (l + h) / 2;
        }
        return index;
    }
}
