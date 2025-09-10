import java.util.Arrays;

public class Leetcode309 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][] memo = new int[n + 1][2];
        // for (int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }
        // return dfs(n - 1, 0, prices, memo);

        // int[][] dp = new int[n + 2][2];
        // dp[0][1] = Integer.MIN_VALUE / 2;
        // dp[1][1] = Integer.MIN_VALUE / 2;
        // for (int i = 0; i < n; i++) {
        //     dp[i + 2][0] = Math.max(dp[i + 1][0], dp[i + 1][1] + prices[i]);
        //     dp[i + 2][1] = Math.max(dp[i + 1][1], dp[i][0] - prices[i]);
        // }
        // return dp[n + 1][0];

        int pre0 = 0;
        int p0 = 0;
        int p1 = Integer.MIN_VALUE;
        for (int p : prices) {
            int newP0 = Math.max(p0, p1 + p);
            p1 = Math.max(p1, pre0 - p);
            pre0 = p0;
            p0 = newP0;
        }
        return p0;
    }
    private int dfs(int i, int hold, int[] prices, int[][] memo) {
        if (i < 0) {
            return hold == 1 ? Integer.MIN_VALUE / 2 : 0;
        }
        if (memo[i][hold] != -1) return memo[i][hold];

        if (hold == 1) {
            return memo[i][hold] = Math.max(dfs(i - 1, 1, prices, memo), dfs(i - 2, 0, prices, memo) - prices[i]);
        }
        return memo[i][hold] = Math.max(dfs(i - 1, 0, prices, memo), dfs(i - 1, 1, prices, memo) + prices[i]);
    }
}
