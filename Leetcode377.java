import java.util.Arrays;

public class Leetcode377 {
    public int combinationSum4(int[] nums, int target) {
        // int[] memo = new int[target + 1];
        // Arrays.fill(memo, -1);
        // return dfs(target, nums, memo);
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int x : nums) {
                if (x <= i) {
                    dp[i] += dp[i - x];
                }
            }
        }
        return dp[target];

        // follow up
        // if has negative number [1, -1], target is 1, we may have infinite answer
        // In order to has limited answer, we can restrict number of negative number
    }
    private int dfs(int i, int[] nums, int[] memo) {
        if (i == 0) return 1;
        if (memo[i] != -1) return memo[i];

        int res = 0;
        for (int x : nums) {
            if (x <= i) {
                res += dfs(i - x, nums, memo);
            }
        }
        return memo[i] = res;
    }
}
