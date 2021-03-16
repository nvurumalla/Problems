package arrays;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        int max = findMax(input);
        System.out.println("Max number is : " + max);
    }

    private static int findMax(int[] a) {
        int maxSoFar = a[0];
        int max = a[0];
        int b = 0;
        int e = 0;
        int bSoFar = 0;
        int eSoFar = 0;

        for (int i = 1; i < a.length; i++) {
            maxSoFar = Math.max(maxSoFar + a[i], a[i]);
            if (maxSoFar == a[i]) {
                bSoFar = i;
                eSoFar = i;
            } else {
                eSoFar = i;
            }
            max = Math.max(max, maxSoFar);
            if (max == maxSoFar) {
                b = bSoFar;
                e = eSoFar;
            }
        }

        System.out.println(b);
        System.out.println(e);
        return max;
    }
}
