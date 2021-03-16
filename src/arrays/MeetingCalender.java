package arrays;


public class MeetingCalender {
    public static void main(String[] args) {
        int b1[][] = {{1, 2}, {4, 6}, {7, 9}, {11, 15}};
        int b2[][] = {{2, 5}, {6, 9}, {12, 17}};

//		int a1[][] = {{9,10},{12,14},{15,18}};
//		int a2[][] = {{11,13},{14,18}};

        int res[] = findCommonTime(b1, b2, 3);
        System.out.println("Meeting start time: " + res[0]);
        System.out.println("Meeting end time: " + res[1]);
    }

    private static int[] findCommonTime(int[][] a1, int[][] a2, int dur) {
        int l1 = 0, l2 = 0;
        int h1 = 0, h2 = 0;
        int time = 0;
        int i = 0, j = 0;
        int meet[] = {0, 0};
        while (i < a1.length && j < a2.length) {
            l1 = a1[i][0];
            h1 = a1[i][1];
            l2 = a2[j][0];
            h2 = a2[j][1];

            if (h1 <= l2) {
                i++;
            } else if (h2 <= l1) {
                j++;
            } else {
                time = Math.min(h1, h2) - Math.max(l1, l2);
                if (time < dur) {
                    i++;
                    j++;
                } else {
                    meet[0] = Math.max(l1, l2);
                    meet[1] = Math.min(h1, h2) - (time - dur);
                    break;
                }
            }
        }
        return meet;
    }
}
