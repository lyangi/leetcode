import java.util.Arrays;

public class Leetcode188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // int[][][] memo = new int[n][k + 1][2];
        // for (int[][] mat : memo) {
        // for (int[] row : mat) {
        // Arrays.fill(row, -1);
        // }
        // }
        // return dfs(n - 1, k, 0, prices, memo);

        // int[][][] dp = new int[n + 1][k + 2][2];
        // for (int[][] mat : dp) {
        // for (int[] row : mat) {
        // Arrays.fill(row, Integer.MIN_VALUE / 2);
        // }
        // }
        // for (int j = 0; j < k + 2; j++) {
        // dp[0][j][0] = 0;
        // }
        // for (int i = 0; i < n; i++) {
        // for (int j = 1; j < k + 2; j++) {
        // dp[i + 1][j][0] = Math.max(dp[i][j][0], dp[i][j - 1][1] + prices[i]);
        // dp[i + 1][j][1] = Math.max(dp[i][j][1], dp[i][j][0] - prices[i]);
        // }
        // }
        // return dp[n][k + 1][0];

        int[][] dp = new int[k + 2][2];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE / 2);
        }
        dp[0][0] = Integer.MIN_VALUE / 2;
        for (int p : prices) {
            for (int j = k + 1; j > 0; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + p);
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - p);
            }
        }
        return dp[k + 1][0];

    }

    private int dfs(int i, int j, int hold, int[] prices, int[][][] memo) {
        if (j < 0)
            return Integer.MIN_VALUE / 2;
        if (i < 0) {
            return hold == 1 ? Integer.MIN_VALUE / 2 : 0;
        }
        if (memo[i][j][hold] != -1)
            return memo[i][j][hold];

        if (hold == 1) {
            return memo[i][j][hold] = Math.max(dfs(i - 1, j, 1, prices, memo),
                    dfs(i - 1, j, 0, prices, memo) - prices[i]);
        }
        return memo[i][j][hold] = Math.max(dfs(i - 1, j, 0, prices, memo),
                dfs(i - 1, j - 1, 1, prices, memo) + prices[i]);
    }
}
