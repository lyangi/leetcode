public class Leetcode070 {
    
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return dfs(n, memo);
    }
    private int dfs(int i, int[] memo) {
        if (i <= 1) return 1;
        if (memo[i] != 0) return memo[i];
        return memo[i] = dfs(i - 1, memo) + dfs(i - 2, memo);
    }

    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs3(int n) {
        int p0 = 1, p1 = 1;
        for (int i = 2; i < n + 1; i++) {
            int cur = p1 + p0;
            p0 = p1;
            p1 = cur;
        }
        return p1;
    }
}
