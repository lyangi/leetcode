import java.util.Arrays;

public class Leetcode122 {
    public static int maxProfit1(int[] prices) {
        int max = 0;
        int start = prices[0];
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (start < prices[i]) {
                max += prices[i] - start;
            }
            start = prices[i];
        }
        return max;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int[][] memo = new int[n + 1][2];
        // for (int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }
        // return dfs(n - 1, 0, prices, memo);

        // int[][] dp = new int[n + 1][2];
        // dp[0][1] = Integer.MIN_VALUE / 2;
        // for (int i = 0; i < n; i++) {
        //     dp[i+1][0] = Math.max(dp[i][0], dp[i][1] + prices[i]);
        //     dp[i+1][1] = Math.max(dp[i][1], dp[i][0] - prices[i]);
        // }
        // return dp[n][0];

        int p0 = 0;
        int p1 = Integer.MIN_VALUE / 2;
        for (int p : prices) {
            int newP0 = Math.max(p0, p1 + p);
            p1 = Math.max(p1, p0 - p);
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
            return memo[i][hold] = Math.max(dfs(i - 1, 1, prices, memo), dfs(i - 1, 0, prices, memo) - prices[i]);
        }
        return memo[i][hold] = Math.max(dfs(i - 1, 0, prices, memo), dfs(i - 1, 1, prices, memo) + prices[i]);
    }
    public static void main(String[] args) {
        int[] prices = {7,1,1,3,6,9};
        System.out.println(maxProfit(prices));
    }
}
