package strings;

/*  'M' : 1000,
  'D' : 500,
  'C' : 100,
  'L' : 50,
  'X' : 10,
  'V' : 5,
  'I' : 1*/

//roman_to_arabic("XX") - 20
//roman_to_arabic("XXIX") - 29
//roman_to_arabic("IXX") - 19 -- XIX
//roman_to_arabic("IX") - 9
//roman_to_arabic("CMX") - 910
//roman_to_arabic("CMIX") - 910
//roman_to_arabic("zzz") - INVALID
//roman_to_arabic("cmx")  - 910

// "XVI"
/*
map -> initial data
roman
c -> c > c+1 -> (c+1)-c
*/
import java.io.*;
import java.util.*;

public class RomanToArabic {
    private static HashMap<Character, Integer> map = new HashMap<>();
    // private static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        String s = "CMX";
        System.out.println(romanToArabic(s));
    }

    private static int romanToArabic(String roman) {
        if (roman == null || roman.length()==0) {
            return -1;
        }

        int arabic = 0;
        for (int i = 0; i < roman.length(); i++) {
            char c = roman.charAt(i);
            if (i+1 < roman.length() && map.get(c) < map.get(roman.charAt(i+1))) {
                arabic = arabic + map.get(roman.charAt(i+1))-map.get(c);
                i++;
            } else {
                arabic = arabic + map.get(c);
            }
        }

        return arabic;
    }
}