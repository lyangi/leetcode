import java.util.Arrays;

public class Leetcode518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        // int[][] memo = new int[n + 1][amount + 1];
        // for (int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }
        // return dfs(n - 1, amount, coins, memo);

        // int[][] dp = new int[n + 1][amount + 1];
        // dp[0][0] = 1;
        // for (int i = 1; i < n + 1; i++) {
        //     int coin = coins[i - 1];
        //     for (int j = 0; j < amount + 1; j++) {
        //         if (j < coin) {
        //             dp[i][j] = dp[i - 1][j];
        //         } else {
        //             dp[i][j] = dp[i - 1][j] + dp[i][j - coin];
        //         }
        //     }
        // }
        // return dp[n][amount];

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j < amount + 1; j++) {
                dp[j] = dp[j] + dp[j - coin];
            }
        }
        return dp[amount];
    }
    private int dfs(int i, int c, int[] coins, int[][] memo) {
        // base case
        if (i < 0) {
            return c == 0 ? 1 : 0;
        }
        if (memo[i][c] != -1) return memo[i][c];

        if (c < coins[i]) {
            return memo[i][c] = dfs(i - 1, c, coins, memo);
        }
        return memo[i][c] = dfs(i - 1, c, coins, memo) + dfs(i, c - coins[i], coins, memo);
    }
}
