import java.util.HashSet;

public class Leetcode003 {
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

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] cnt = new int[128];
        int n = s.length();
        int l = 0;
        int ans = 0;
        for (int r = 0; r < n; r++) {
            cnt[s.charAt(r)]++;
            while (cnt[s.charAt(r)] > 1) {
                cnt[s.charAt(l++)]--;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}
