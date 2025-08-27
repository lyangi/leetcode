import java.util.Arrays;

public class Leetcode494 {
    // 0/1 knapsack
    // dfs(i, c) = max(dfs(i - 1, c), dfs(i - 1, c - w[i]) + v[i]);
    public int findTargetSumWays(int[] nums, int target) {
        // p
        // s - p
        // p - (s - p) = t
        // 2p = s + t;
        // p = (s + t) / 2;
        int n = nums.length;
        int sum = 0;
        for (int x : nums) {
            sum += x;
        }
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) return 0;
        int c = (sum + target) / 2;

        // int[][] memo = new int[n + 1][c + 1];
        // for (int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }
        // return dfs(n - 1, c, nums, memo);

        int[][] dp = new int[n + 1][c + 1];
        dp[0][0] = 1; // base case
        for (int i = 1; i < n + 1; i++) {
            int num = nums[i - 1];
            for (int j = 0; j < c + 1; j++) {
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                }
            }
        }
        return dp[n][c];
    }
    private int dfs(int i, int c, int[] nums, int[][] memo) {
        // base case
        if (i < 0) {
            return c == 0 ? 1 : 0;
        }
        if (memo[i][c] != -1) return memo[i][c];

        if (c < nums[i]) {
            return memo[i][c] = dfs(i - 1, c, nums, memo); // not pick
        }
        return memo[i][c] = dfs(i - 1, c, nums, memo) + dfs(i - 1, c - nums[i], nums, memo);
    }
}
