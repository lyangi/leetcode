import java.util.Arrays;

public class Leetcode516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // int[][] memo = new int[n][n];
        // for (int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }
        // return dfs(0, n - 1, s.toCharArray(), memo);

        // int[][] dp = new int[n][n];
        // for (int i = n - 1; i >= 0; i--) {
        //     dp[i][i] = 1;
        //     for (int j = i + 1; j < n; j++) {
        //         if (s.charAt(i) == s.charAt(j)) {
        //             dp[i][j] = dp[i + 1][j - 1] + 2;
        //         } else {
        //             dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        //         }
        //     }
        // }
        // return dp[0][n - 1];

        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j] = pre + 2;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = temp;
            }
        }
        return dp[n - 1];
    }
    private int dfs(int i, int j, char[] s, int[][] memo) {
        // base case
        if (i == j) return 1;
        if (i > j) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        if (s[i] == s[j]) {
            return memo[i][j] = dfs(i + 1, j - 1, s, memo) + 2;
        }
        return memo[i][j] = Math.max(dfs(i + 1, j, s, memo), dfs(i, j - 1, s, memo));
    }
}
