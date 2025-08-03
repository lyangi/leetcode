public class Leetcode2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        int ans = 0;
        int l = 0;
        int repet = 0;
        for (int r = 0; r < n; r++) {
            if (r > 0 && s.charAt(r) == s.charAt(r - 1)) repet++;
            while (repet > 1) {
                l++;
                if (s.charAt(l) == s.charAt(l - 1)) repet--;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
    
}
