public class Leetcode1004 {
    public static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        if (k == n) return n;
        int cnt = 0;
        int l = 0;
        int ans = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) cnt++;
            while (cnt > k) {
                if (nums[l] == 0) cnt--;
                l++;
            }
            ans = Math.max(ans, r - l + 1); 
        }
        return ans;
    }
}
