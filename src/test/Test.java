package test;

import java.math.BigInteger;
import java.util.*;

public class Test {

    // swap() doesn't swap i and j
    public static void swap(TestClass tc) {
        int temp = tc.getI();
        tc.setI(tc.getJ());
        tc.setJ(temp);
    }

    public static void main(String[] args) {
//		System.out.println(lengthOfLongestSubstringTwoDistinct("abaaac"));
//		System.out.println(longestPalindrome("abba"));
//		System.out.println(isOneEditDistance("abb", "acc"));
//        System.out.println(reverseInt(463847413));
//        Map<String, String> map = new HashMap<>();
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
//        String A = "hello";
//        String B = "java";
//        System.out.println(A.length()+B.length());
//        System.out.println(A.compareTo(B) >= 0 ? "Yes" : "No");
//        A = Character.toUpperCase(A.charAt(0)) + A.substring(1);
//        B = Character.toUpperCase(B.charAt(0)) + B.substring(1);
//        System.out.println(A + " " + B);
//
//        String s = "welcometojava";
//        int k = 3;
//        String smallest = "";
//        String largest = "";
//
//        // Complete the function
//        // 'smallest' must be the lexicographically smallest substring of length 'k'
//        for (int i = 0; i <= s.length()-k; i++) {
//            String subStr = s.substring(i, i+k);
//            if (smallest=="" || subStr.compareTo(smallest) < 0) {
//                smallest = subStr;
//            }
//            if (subStr.compareTo(largest) > 0) {
//                largest = subStr;
//            }
//        }
//
//        System.out.println(smallest + "\n" + largest);

        String s = "                        ";

//        s = s.stripLeading();
//        s = s.stripTrailing();
//        String[] sarr = s.split("[ !,?._'@]+");
//        System.out.println(sarr.length);
//        for (String token : sarr) {
//            System.out.println(token);
//        }

        int i = 0;
        for (; i < s.length(); i++) {
            if(s.charAt(i) != ' ') {
                break;
            }
        }
        s = s.substring(i);
        for (i = s.length()-1; i>=0 ; i--) {
            if (s.charAt(i) != ' ') {
                break;
            }
        }
        s = s.substring(0, i+1);
        if (s == "") {
            System.out.println("0");
        } else {
            String[] sarr = s.split("[ !,?._'@]+");
            System.out.println(sarr.length);
            for (String token : sarr) {
                System.out.println(token);
            }
        }


//		1463847412
//		int n=25;
//		BigInteger factorial = new BigInteger(String.valueOf(n));
//		for (int i=n-1; i>0; i--) {
//			BigInteger bi = new BigInteger(String.valueOf(i));
//			factorial=factorial.multiply(bi);
//		}
//		System.out.println(factorial);
//
//
//		int[] arr = {1,2,3,4,5};
//		int sum = 0;
//		int min_el = arr[0], max_el = arr[0];
//		for (int i : arr) {
//			min_el = Math.min(min_el, i);
//			max_el = Math.max(max_el, i);
//			sum = sum+i;
//		}
//		System.out.println(min_el);
//		System.out.println(max_el);
//		System.out.print((sum-max_el) + " " + (sum-min_el));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int i = 0, j = -1, maxLen = 0;
        for (int k = 1; k < s.length(); k++) {
            if (s.charAt(k) == s.charAt(k - 1)) continue;
            if (j >= 0 && s.charAt(j) != s.charAt(k)) {
                maxLen = Math.max(k - i, maxLen);
                i = j + 1;
            }
            j = k - 1;
        }
        return Math.max(s.length() - i, maxLen);
    }

    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    private static boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) {
            return isOneEditDistance(t, s);
        }
        if (n - m > 1) {
            return false;
        }
        int i = 0, j = 0;
        int count = 0;
        if (m == n) {
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) != t.charAt(j)) {
                    if (count == 1) {
                        return false;
                    }
                    count++;
                }
                i++;
                j++;
            }
        }
        i = 0;
        j = 0;
        count = 0;
        if (n - m == 1) {
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) != t.charAt(j)) {
                    if (count == 1) {
                        return false;
                    }
                    count++;
                    j++;
                    continue;
                }
                i++;
                j++;
            }
        }
        return true;
    }

    private static int reverseInt(int x) {
        int ret = 0;
        while (x != 0) {
// handle overflow/underflow
            if (Math.abs(ret) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }

    private static List<Integer> plusOne(List<Integer> intarray) {
        int carry = 0;
        for (int i = intarray.size() - 1; i >= 0; i++) {
            if (intarray.get(i) == 9) {
                carry = 1;
            }
        }
        return null;
    }
}
