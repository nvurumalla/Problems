package arrays;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] input = {1, 3, -3, 4};
        int sum = 0;
        int[] output = twoSum(input, sum);
        if (output == null) {
            System.out.println("No indices found");
        } else {
            for (int i : output) {
                System.out.println("index is " + i + "... value is " + input[i]);
            }
        }
    }

    private static int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];

//		O(n2)
//		for (int i = 0; i < input.length; i++) {
//			for (int j = i; j<input.length; j++) {
//				if (input[i] + input[j] == sum) {
//					output[0] = i;
//					output[1] = j;
//					return output;
//				}
//			}
//		}


//		O(nlogn)
//		sort the array, have 2 pointers. If sum > expected move right pointer. If sum < expected move left pointer
//		int a = input[0];
//		int b = input[input.length-1];
//		while(true) {
//			if(input[a]+input[b] > sum) {
//				b = b--;
//			} else if(input[a]+input[b] > sum) {
//				a = a++;
//			} else if(input[a]+input[b] == sum) {
//				output[0] = a;
//				output[1] = b;
//				return output;
//			}
//		}


//		O(n)
        HashMap<Integer, Integer> inputMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (inputMap.containsKey(target - nums[i])) {
                output[0] = i;
                output[1] = inputMap.get(target - nums[i]);
                return output;
            } else {
                inputMap.put(nums[i], i);
            }
        }
        return null;
    }

}
