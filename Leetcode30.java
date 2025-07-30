import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode30 {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int wordLen = words[0].length();
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> windowMap = new HashMap<>();
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                if (wordCount.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    if (windowMap.get(word) <= wordCount.get(word)) {
                        count++;
                    } else {
                        while (windowMap.get(word) > wordCount.get(word)) {
                            String leftword = s.substring(left, left + wordLen);
                            windowMap.put(leftword, windowMap.get(leftword) - 1);
                            if (windowMap.get(leftword) < wordCount.get(leftword)) {
                                count--;
                            }
                            left += wordLen;
                        }
                    }
                    if (count == words.length) {
                        ans.add(left);
                    }

                } else {
                    left = right;
                    windowMap.clear();
                    count = 0;
                }

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "barfoobarman";
        String[] words = {"foo","bar"};
        findSubstring(s, words);
    }
}