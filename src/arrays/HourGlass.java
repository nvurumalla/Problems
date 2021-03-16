package arrays;

public class HourGlass {
    public static void main(String[] args) {

        int[][] arr = {{1,1,1,0,0,0},
                {0,1,0,0,0,0},
                {1,1,1,0,0,0},
                {0,9,2,-4,-4,0},
                {0,0,0,-2,0,0},
                {0,0,-1,-2,-4,0}};

        int maxSum = arr[0][0] + arr[0][1] + arr[0][2]
                +arr[1][1]
                + arr[2][0] + arr[2][1]+ arr[2][2];
        for (int i=0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                        +arr[i+1][j+1]
                        + arr[i+2][j] + arr[i+2][j+1]+ arr[i+2][j+2];
                maxSum = Math.max(sum, maxSum);
            }
        }
        System.out.println(maxSum);
    }
}
