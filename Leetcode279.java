import java.util.Arrays;

public class Leetcode279 {
    public int numSquares(int n) {
        // sqrt(n)
        // int[][] memo = new int[101][10001];
        // for (int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }
        // return dfs((int) Math.sqrt(n), n, memo);

        // int[][] dp = new int[101][10001];
        // Arrays.fill(dp[0], Integer.MAX_VALUE / 2);
        // dp[0][0] = 0;
        // for (int i = 1; i < 101; i++) {
        //     for (int j = 0; j < 10001; j++) {
        //         if (j < i * i) {
        //             dp[i][j] = dp[i - 1][j];
        //         } else {
        //             dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - i*i] + 1);
        //         }
        //     }
        // }
        // return dp[(int) Math.sqrt(n)][n];

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;

        for (int i = 1; i < 101; i++) {
            for (int j = i * i; j < n + 1; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
    private int dfs(int i, int c, int[][] memo) {
        if (i == 0) {
            return c == 0 ? 0 : Integer.MAX_VALUE / 2;
        }
        if (memo[i][c] != -1) return memo[i][c];

        if (c < i * i) {
            return memo[i][c] = dfs(i - 1, c, memo);
        }
        return memo[i][c] = Math.min(dfs(i - 1, c, memo), dfs(i, c - i * i, memo) + 1);
    }
}
