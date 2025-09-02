import java.util.Arrays;

public class Leetcode097 {
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] t = s3.toCharArray();

        int m = c1.length;
        int n = c2.length;
        if (m + n != t.length)
            return false;
        // m + n - 1
        // m - 1 + n - 1 + 1

        // int[][] memo = new int[m + 1][n + 1];
        // for (int[] row : memo) {
        // Arrays.fill(row, -1);
        // }
        // return dfs(m - 1, n - 1, c1, c2, t, memo);

        // boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[0][0] = true;
        // for (int j = 1; j < n + 1; j++) {
        //     dp[0][j] = c2[j - 1] == t[j - 1] && dp[0][j - 1];
        // }
        // for (int i = 1; i < m + 1; i++) {
        //     dp[i][0] = c1[i - 1] == t[i - 1] && dp[i - 1][0];
        //     for (int j = 1; j < n + 1; j++) {
        //         dp[i][j] = c1[i - 1] == t[i + j - 1] && dp[i - 1][j] || c2[j - 1] == t[i + j - 1] && dp[i][j - 1];
        //     }
        // }
        // return dp[m][n];

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j < n + 1; j++) {
            dp[j] = c2[j - 1] == t[j - 1] && dp[j - 1];
        }
        for (int i = 1; i < m + 1; i++) {
            dp[0] = c1[i - 1] == t[i - 1] && dp[0];
            for (int j = 1; j < n + 1; j++) {
                dp[j] = c1[i - 1] == t[i + j -1] && dp[j] || c2[j - 1] == t[i + j - 1] && dp[j - 1];
            }
        }
        return dp[n];
    }

    private boolean dfs(int i, int j, char[] c1, char[] c2, char[] t, int[][] memo) {
        if (i < 0 && j < 0)
            return true;

        if (memo[i + 1][j + 1] != -1)
            return memo[i + 1][j + 1] == 1;

        boolean res = i >= 0 && c1[i] == t[i + j + 1] && dfs(i - 1, j, c1, c2, t, memo)
                || j >= 0 && c2[j] == t[i + j + 1] && dfs(i, j - 1, c1, c2, t, memo);
        memo[i + 1][j + 1] = res ? 1 : 0;
        return res;
    }
}
