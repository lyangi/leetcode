import java.util.HashSet;

public class Leetcode03 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int start = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                max = Math.max(max, set.size());
                while(set.contains(c)) {
                    set.remove(s.charAt(start++));
                }
            }
            set.add(c);
        }
        return Math.max(max, set.size());
    }
}
