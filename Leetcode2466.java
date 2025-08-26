import java.util.Arrays;

public class Leetcode2466 {
    private static final int MOD = 1_000_000_007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        int ans = 0;
        // int[] memo = new int[high + 1];
        // Arrays.fill(memo, -1);

        // for (int i = low; i <= high; i++) {
        //     ans = (ans + dfs(i, zero, one, memo)) % MOD;
        // }
        // return ans;

        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 1; i < high + 1; i++) {
            if (i >= zero) dp[i] = dp[i - zero];
            if (i >= one) dp[i] = (dp[i] + dp[i - one]) % MOD;
            if (i >= low) ans = (ans + dp[i]) % MOD;
        }
        return ans;
    }
    
    private int dfs(int i, int zero, int one, int[] memo) {
        if (i < 0) return 0;
        if (i == 0) return 1;
        if (memo[i] != -1) return memo[i];

        return memo[i] = (dfs(i - zero, zero, one, memo) + dfs(i - one, zero, one, memo)) % MOD;
    }
}
