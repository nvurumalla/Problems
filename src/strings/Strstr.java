package strings;

/**
 * Find needle in haystack
 * Clean code handbook problem:5
 */
public class Strstr {

    public int strstr(String needle, String haystack) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        if (haystack == null || haystack.length() == 0 || needle.length() > haystack.length()) {
            return -1;
        }
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (haystack.indexOf(i + j) != needle.indexOf(j)) {
                    break;
                }
            }
        }
    }
}
