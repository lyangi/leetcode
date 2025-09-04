import java.util.ArrayList;
import java.util.List;

public class Leetcode300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 0;
        // int[] memo = new int[n];
        // for (int i = 0; i < n; i++) {
        //     ans = Math.max(ans, dfs(i, nums, memo));
        // }
        // return ans;

        // int[] dp = new int[n];
        // dp[0] = 0;
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (nums[j] < nums[i]) {
        //             dp[i] = Math.max(dp[i], dp[j]);
        //         }
        //     }
        //     ans = Math.max(ans, ++dp[i]);
        // }
        // return ans;

        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            int index = lowerBound(x, list);
            if (index == list.size()) {
                list.add(x);
            } else {
                list.set(index, x);
            }
        }
        return list.size();
    }
    private int lowerBound(int target, List<Integer> list) {
        int l = 0, r = list.size() - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    private int dfs(int i, int[] nums, int[] memo) {
        if (i < 0) return 0;
        if (memo[i] > 0) return memo[i];

        int res = 0;
        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                res = Math.max(res, dfs(j, nums, memo));
            }
        }
        res++;
        return memo[i] = res;
    }
}
