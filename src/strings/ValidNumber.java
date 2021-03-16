package strings;

/**
 * Validate if a given string is numeric.
 * Clean code handbook problem:9
 */
public class ValidNumber {

    public boolean isValidNumber(String s) {
        char[] c = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (c[i] == ' ') {
            i++;
        }
        while (c[j] == ' ') {
            j--;
        }
        if (c[i] == '+' || c[i] == '-') {
            i++;
        }
        int decimal = 0;

        for (int k = i; k <= j; k++) {
            if (c[k] == '.') {
                if (decimal == 1
                        || ((k - 1 >= 0 && !Character.isDigit(c[k - 1])) && (k + 1 < s.length() && !Character.isDigit(c[k + 1])))
                        || (k - 1 < 0 && k + 1 == s.length())) {
                    return false;
                } else {
                    decimal++;
                }
            }
            if (!Character.isDigit(c[k])) {
                break;
            }
        }
        return true;
    }

    public boolean isNumber(String s) {
        int i = 0, n = s.length();
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
        boolean isNumeric = false;
        while (i < n && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }
        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        if (isNumeric && i < n && s.charAt(i) == 'e') {
            i++;
            isNumeric = false;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        while (i < n && Character.isWhitespace(s.charAt(i))) i++;
        return isNumeric && i == n;
    }
}
