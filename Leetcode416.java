import java.util.Arrays;

public class Leetcode416 {
    public boolean canPartition(int[] nums) {
        // pick sum / 2
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int c = sum / 2;

        // int[][] memo = new int[n + 1][c + 1];
        // for (int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }

        // return dfs(n - 1, c, nums, memo);

        // boolean[][] dp = new boolean[n + 1][c + 1];
        // Arrays.fill(dp[0], false);
        // dp[0][0] = true;

        // for (int i = 1; i < n + 1; i++) {
        //     int num = nums[i - 1];
        //     for (int j = 0; j < c + 1; j++) {
        //         if (j < num) {
        //             dp[i][j] = dp[i - 1][j];
        //         } else {
        //             dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
        //         }
        //     }
        // }
        // return dp[n][c];

        boolean[] dp = new boolean[c + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int j = c; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[c];
    }
    private boolean dfs(int i, int c, int[] nums, int[][] memo) {
        // base case
        if (i < 0) {
            return c == 0;
        }
        if (memo[i][c] != -1) return memo[i][c] == 1;

        boolean res = false;
        if (c < nums[i]) {
            res = dfs(i - 1, c, nums, memo);
        } else {
            res = dfs(i - 1, c, nums, memo) || dfs (i - 1, c - nums[i], nums, memo);
        }
        memo[i][c] = res ? 1 : 0;
        return res;
    }
}
