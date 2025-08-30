import java.util.Arrays;

public class Leetcode072 {
    public int minDistance(String word1, String word2) {
        // horse ros
        // delete dfs(i - 1, j)
        // insert dfs(i, j - 1)
        // replace dfs(i - 1, j - 1)

        int m = word1.length();
        int n = word2.length();
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();

        // int[][] memo = new int[m + 1][n + 1];
        // for (int[] row : memo) {
        //     Arrays.fill(row, -1);
        // }

        // return dfs(m - 1, n - 1, s, t, memo);

        // int[][] dp = new int[m + 1][n + 1];
        // for (int j = 0; j < n + 1; j++) {
        //     dp[0][j] = j;
        // }
        // for (int i = 0; i < m + 1; i++) {
        //     dp[i][0] = i;
        // }
        // for (int i = 1; i < m + 1; i++) {
        //     for (int j = 1; j < n + 1; j++) {
        //         if (s[i - 1] == t[j - 1]) {
        //             dp[i][j] = dp[i - 1][j - 1];
        //         } else {
        //             dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
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
        for (int j = 0; j < n + 1; j++) {
            dp[j] = j; // dp[0][j]
        }
        for (int i = 1; i < m + 1; i++) {
            int pre = dp[0]; // dp[i - 1][0]
            dp[0] = i; // dp[i][0] = i
            for (int j = 1; j < n + 1; j++) {
                int temp = dp[j]; // dp[i - 1][j]
                if (s[i - 1] == t[j - 1]) {
                    dp[j] = pre;
                } else {
                    dp[j] = Math.min(Math.min(dp[j], dp[j - 1]), pre) + 1;
                }
                pre = temp;
            }
        }
        return dp[n];
    }
    private int dfs(int i, int j, char[] s, char[] t, int[][] memo) {
        // base case
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (memo[i][j] != -1) return memo[i][j];

        if (s[i] == t[j]) return memo[i][j] = dfs(i - 1, j - 1, s, t, memo);

        return memo[i][j] = Math.min(Math.min(dfs(i - 1, j, s, t, memo), dfs(i, j - 1, s, t, memo)), dfs(i - 1, j - 1, s, t, memo)) + 1;
    }
}
