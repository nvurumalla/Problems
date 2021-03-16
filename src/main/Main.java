package main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import arrays.TwoSum1;
import arrays.TwoSum1.Pair;
import strings.Anagram;
import strings.IsPalindrome;
import strings.ValidNumber;

public class Main {

    public static void main(String[] args) throws Exception {

//		twoSum();
//		twoSumUnique();
//		isPalindrome();
//		isPalindromeWithNonNumberics();

//        ValidNumber vn = new ValidNumber();
//		System.out.println(vn.isValidNumber("."));
//        System.out.println(vn.isNumber("1.a"));

        Anagram ag = new Anagram();
        System.out.println(ag.isAnagram("aap", "paa"));
//        System.out.println(Character.getNumericValue('a'));
    }

    private static void isPalindromeWithNonNumberics() {
        IsPalindrome ip = new IsPalindrome();
        String s = "";
        boolean result = ip.alphaNumericCaseInsensitive(s);
        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("NOT Palindrome");
        }
    }

    private static void isPalindrome() {
        IsPalindrome ip = new IsPalindrome();
        String s = "aabcbbcbaa";
        boolean result = ip.isPalindrome(s);
        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("NOT Palindrome");
        }
    }

    private static void twoSum() {
        TwoSum1 twoSum = new TwoSum1();
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] result = twoSum.findTwoSum(a, 10);
        if (result != null) {
            System.out.println("Matching indices: " + result[0] + "," + result[1]);
            System.out.println("Matching integers: " + a[result[0]] + "," + a[result[1]]);
        } else {
            System.out.println("No result");
        }
    }

    private static void twoSumUnique() {
        TwoSum1 twoSum = new TwoSum1();
        int[] a = {1, 3, 1, 3, 2, 2, 2, 2};
        List<Pair> result = twoSum.findUniquePairs(a, 4);
        System.out.println("Number of unique pairs: " + result.size());
        for (Pair p : result) {
            System.out.println("Pair: " + p.getA() + ", " + p.getB());
        }
    }
}
