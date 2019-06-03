package arrays;

public class DutchNationalFlag {
    private static void dutchNationFlag(int index, int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int pivot = a[index];
        int lower = 0;
        int equal = 0;
        int upper = a.length-1;

        while (equal < upper) {
            if (a[equal] < pivot) {
                swap(lower, equal, a);
                equal++;
                lower++;
            } else if (a[equal] > pivot) {
                swap(equal, --upper, a);
            } else {
                equal++;
            }
        }
    }

    private static void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,0,1,1,0,2,2};
        dutchNationFlag(4 ,a);

        for (int i:a) {
            System.out.print(i);
        }
    }
}
