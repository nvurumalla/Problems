package strings;

/**
 * Implement atoi to convert a string to an integer
 * Clean code handbook problem:8
 */
public class AtoI {
    public static void main(String[] args) {
        System.out.println(atoi("   2147483648"));
    }

    private static int atoi(String s) {

        int max = Integer.MAX_VALUE / 10;
        int n = s.length();
        int i = 0;
        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        int number = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = Character.getNumericValue(s.charAt(i));
            if (number > max || (number == max && digit >= 8)) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            number = (number * 10) + digit;
            i++;
        }

        return sign * number;
    }
}
