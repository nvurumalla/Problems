package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-4, -1, -1, 0, 1, 2};
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> l : result) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> outerMap = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (outerMap.containsKey(nums[i])) {
                continue;
            }
            int target = 0 - nums[i];
            outerMap.put(nums[i], i);
            HashMap<Integer, Integer> innerMap = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (innerMap.containsKey(target - nums[j]) && innerMap.get(target - nums[j]) >= 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(target - nums[j]);
                    tmp.add(nums[j]);
                    innerMap.put(target - nums[j], -1);
                    innerMap.put(nums[j], -1);
                    result.add(tmp);
                } else if (!innerMap.containsKey(nums[j])) {
                    innerMap.put(nums[j], j);
                }
            }
        }
        return result;
    }

    /*public static int[] input = {-4,-1,-1,0,1,2};

    public static int sum = 0;

    public static void threeSum(int[] input, int sum) {
        //first of all sort the input

//        QuickSort.sort(input, 0, input.length -1);

        for( int i = 0; i< input.length ; i++) {

            int start = i+1;
            int end = input.length -1;
            while (start<end) {
                if(input[i] + input[start]+input[end] == sum) {
                    System.out.println("Sum :"+ sum + "  = "+ input[i] + " "+ input[start] + " "+ input[end]);
//                    return;
                } else if(input[i] + input[start]+input[end] < sum) {
                    start++;
                } else {
                    end --;
                }
            }
        }

    }

    public static void main(String[] args) {
        threeSum(input, sum);
    }*/
}
