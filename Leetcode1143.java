import java.util.Arrays;

public class Leetcode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();
        
        // int[][] memo = new int[m + 1][n + 1];
        // for (int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }
        // return dfs(m - 1, n - 1, s, t, memo);

        // int[][] dp = new int[m + 1][n + 1];
        // dp[0][0] = 0;
        // for (int i = 1; i < m + 1; i++) {
        //     for (int j = 1; j < n + 1; j++) {
        //         if (s[i - 1] == t[j - 1]) {
        //             dp[i][j] = dp[i - 1][j - 1] + 1;
        //         } else {
        //             dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        //         }
        //     }
        // }
        // return dp[m][n];

        if (m < n) {
            char[] temp = s;
            s = t;
            t = temp;

            int x = m;
            m = n;
            n = x;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i < m + 1; i++) {
            int pre = dp[0];
            for (int j = 1; j < n + 1; j++) {
                int temp = dp[j];
                if (s[i - 1] == t[j - 1]) {
                    dp[j] = pre + 1;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }
                pre = temp;
            }
        }
        return dp[n];
    }
    private int dfs(int i, int j, char[] s, char[] t, int[][] memo) {
        // base case
        if (i < 0 || j < 0) {
            return 0;
        }

        if (memo[i][j] != -1) return memo[i][j];

        if (s[i] == t[j]) return memo[i][j] = dfs(i - 1, j - 1, s, t, memo) + 1;

        return memo[i][j] = Math.max(dfs(i - 1, j, s, t, memo), dfs(i, j - 1, s, t, memo));
    }
}
