package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
    public boolean isAnagram(String c, String d)
    {
        int[] charArray = new int[26];
        if (c.length() != d.length()) {
            return false;
        }
        for (int i = 0; i < c.length(); i++) {
            charArray[c.charAt(i)-'a']++;
        }
        for (int i = 0; i < d.length(); i++) {
            charArray[d.charAt(i)-'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (charArray[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams(List<String> words) {
        HashMap<String, List<String>> wordMap = new HashMap<>();
        for (String word : words) {
            int[] charArray = new int[26];
            for (int i = 0; i < word.length(); i++) {
                charArray[word.charAt(i)-'a']++;
            }
            StringBuilder count = new StringBuilder("");
            for (int i =0; i<26; i++) {
                count.append('#');
                count.append(charArray[i]);
            }
            String key = count.toString();
            if (!wordMap.containsKey(key)) {
                wordMap.put(key, new ArrayList<>());
            }
            wordMap.get(key).add(word);
        }
        List<List<String>> anagramGroups = new ArrayList<>();
        anagramGroups.addAll(wordMap.values());
        return anagramGroups;
    }
}
