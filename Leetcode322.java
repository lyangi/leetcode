import java.util.Arrays;

public class Leetcode322 {
    // unbounded knapsack
    // dfs(i, c) = max(dfs(i - 1, c), dfs(i, c - w[i]) + v[i]);
    public int coinChange(int[] coins, int amount) {
        // dfs(i, c) = min(dfs(i - 1, c), dfs(i, c - w[i]) + 1);
        int n = coins.length;
        if (n == 0) return 0;
        
        // int[][] memo = new int[n + 1][amount + 1];
        // for (int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }

        // int res = dfs(n - 1, coins, amount, memo);
        // return res < Integer.MAX_VALUE / 2 ? res : -1;

        // int[][] dp = new int[n + 1][amount + 1];
        // Arrays.fill(dp[0], Integer.MAX_VALUE / 2); // if we have 0 coins, any j > 0 is INF
        // dp[0][0] = 0;
        // for (int i = 1; i < n + 1; i++) {
        //     int coin = coins[i - 1];
        //     for (int j = 0; j < amount + 1; j++) {
        //         if (j < coin) {
        //             dp[i][j] = dp[i - 1][j];
        //         } else {
        //             dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coin] + 1);
        //          }
        //     }
        // }
        // return dp[n][amount] < Integer.MAX_VALUE / 2 ? dp[n][amount] : -1;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int x : coins) {
            for (int j = x; j < amount + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - x] + 1);
            }
        }
        return dp[amount] < Integer.MAX_VALUE / 2 ? dp[amount] : -1;
    }
    private int dfs(int i, int[] coins, int c, int[][] memo) {
        // base case
        if (i < 0) {
            return c == 0 ? 0 : Integer.MAX_VALUE / 2;
        }
        if (memo[i][c] != -1) return memo[i][c];

        if (c < coins[i]) {
            return memo[i][c] = dfs(i - 1, coins, c, memo);
        }
        return memo[i][c] = Math.min(dfs(i - 1, coins, c, memo), dfs(i, coins, c - coins[i], memo) + 1);
    }
}
