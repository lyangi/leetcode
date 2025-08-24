import java.util.Arrays;

public class Leetcode746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if (n == 1) return cost[0];
        // int[] memo = new int[n + 1];
        // Arrays.fill(memo, -1);
        // return dfs(n, cost, memo);

        // int[] dp = new int[n + 1];
        // for (int i = 2; i < n + 1; i++) {
        //     dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        // }
        // return dp[n];

        int p0 = 0, p1 = 0;
        for (int i = 2; i < n + 1; i++) {
            int cur = Math.min(p1 + cost[i - 1], p0 + cost[i - 2]);
            p0 = p1;
            p1 = cur;
        }
        return p1;
    }
    private int dfs(int i, int[] cost, int[] memo) {
        if (i <= 1) return 0;
        if (memo[i] != -1) return memo[i];

        int res1 = dfs(i - 1, cost, memo) + cost[i - 1];
        int res2 = dfs(i - 2, cost, memo) + cost[i - 2];
        return memo[i] = Math.min(res1, res2);
    }
}
