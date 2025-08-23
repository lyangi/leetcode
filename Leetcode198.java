import java.util.Arrays;

public class Leetcode198 {
    // recursion with memorization
    public int rob(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(n - 1, nums, memo);
    }
    private int dfs(int i, int[] nums, int[] memo) {
        if (i < 0) return 0;
        if (memo[i] != -1) return memo[i];
        memo[i] = Math.max(dfs(i - 1, nums, memo), dfs(i - 2, nums, memo) + nums[i]);
        return memo[i];
    }

    // dp
    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 2];
        for (int i = 0; i < n; i++) {
            dp[i + 2] = Math.max(dp[i + 1], dp[i] + nums[i]);
        }
        return dp[n + 1];
    }
    public int rob22(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    // dp + space optimal
    public int rob3(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; i++) {
            int cur = Math.max(p1, p0 + nums[i]);
            p0 = p1;
            p1 = cur;
        }
        return p1;
    }
}
