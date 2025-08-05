public class Leetcode1234 {
    public int balancedString(String s) {
        int[] cnt = new int[128];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i)]++;
        }

        int n = s.length();
        int k = n / 4;
        int l = 0;
        int ans = n;
        if (cnt['Q'] == k && cnt['W'] == k && cnt['E'] == k && cnt['R'] == k) return 0;
        for (int r = 0; r < n; r++) {
            cnt[s.charAt(r)]--;
            while (cnt['Q'] <= k && cnt['W'] <= k && cnt['E'] <= k && cnt['R'] <= k) {
                ans = Math.min(ans, r - l + 1);
                cnt[s.charAt(l)]++;
                l++;
            }
        }
        return ans;
    }
}
