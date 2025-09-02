public class Leetcode1092 {
    private char[] s, t;
    private int[][] memo;

    public String shortestCommonSupersequence(String str1, String str2) {
        s = str1.toCharArray();
        t = str2.toCharArray();
        int m = s.length;
        int n = t.length;
        // memo = new int[m + 1][n + 1];
        // return makeAns(m - 1, n - 1);
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = i;
            for (int j = 1; j < n + 1; j++) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        int na = dp[m][n];
        char[] ans = new char[na];
        for (int i = m - 1, j = n - 1, k = na - 1;;) {
            if (i < 0) {
                System.arraycopy(t, 0, ans, 0, j + 1);
                break;
            }
            if (j < 0) {
                System.arraycopy(s, 0, ans, 0, i + 1);
                break;
            }
            if (s[i] == t[j]) {
                ans[k--] = s[i--];
                j--;
            } else if (dp[i][j + 1] < dp[i + 1][j]) {
                ans[k--] = s[i--];
            } else {
                ans[k--] = t[j--];
            }
        }
        return new String(ans);
    }

    private String makeAns(int i, int j) {
        if (i < 0)
            return new String(t, 0, j + 1);
        if (j < 0)
            return new String(s, 0, i + 1);
        if (s[i] == t[j]) {
            return makeAns(i - 1, j - 1) + s[i];
        }
        if (dfs(i - 1, j) < dfs(i, j - 1)) {
            return makeAns(i - 1, j) + s[i];
        } else {
            return makeAns(i, j - 1) + t[j];
        }

    }

    private int dfs(int i, int j) {
        if (i < 0)
            return j + 1;
        if (j < 0)
            return i + 1;
        if (memo[i][j] > 0)
            return memo[i][j];

        if (s[i] == t[j]) {
            return memo[i][j] = dfs(i - 1, j - 1) + 1;
        }
        return memo[i][j] = Math.min(dfs(i - 1, j), dfs(i, j - 1)) + 1;
    }
}
