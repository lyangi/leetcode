import java.util.Arrays;
import java.util.List;

public class Leetcode2915 {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        // int[][] memo = new int[n + 1][target + 1];
        // for (int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }
        // int res = dfs(n - 1, target, nums, memo);
        // return res > 0 ? res : -1;

        // int[][] dp = new int[n + 1][target + 1];
        // Arrays.fill(dp[0], Integer.MIN_VALUE);
        // dp[0][0] = 0;

        // for (int i = 1; i < n + 1; i++) {
        //     int num = nums.get(i - 1);
        //     for (int j = 0; j < target + 1; j++) {
        //         if (j < num) {
        //             dp[i][j] = dp[i - 1][j];
        //         } else {
        //             dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - num] + 1);
        //         }
        //     }
        // }
        // return dp[n][target] > 0 ? dp[n][target] : -1;

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + 1);
            }
        }
        return dp[target] > 0 ? dp[target] : -1;
    }
    private int dfs(int i, int c, List<Integer> nums, int[][] memo) {
        // base case
        if (i < 0) {
            return c == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[i][c] != -1) return memo[i][c];

        if (c < nums.get(i)) {
            return memo[i][c] = dfs(i - 1, c, nums, memo);
        }
        return memo[i][c] = Math.max(dfs(i - 1, c, nums, memo), dfs(i - 1, c - nums.get(i), nums, memo) + 1);
    }
}
