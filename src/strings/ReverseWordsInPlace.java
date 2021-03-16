package strings;

/**
 * Reverse Words in a String
 * “The input string does not contain leading or trailing spaces and the words are always separated by a single space.”
 * Clean code handbook problem:7
 */
public class ReverseWordsInPlace {

    public void reverse(char[] s) {
        reverseString(s, 0, s.length);
        for (int i = 0, j = 0; j < s.length; j++) {
            if (j == s.length || s[j] == ' ') {
                reverseString(s, i, j);
                i = j + 1;
            }
        }
    }

    public void reverseString(char[] s, int begin, int end) {
        for (int i = 0; i < (end - begin) / 2; i++) {
            char tmp = s[begin + i];
            s[begin + i] = s[end - i - 1];
            s[end - i - 1] = tmp;
        }
    }
}
