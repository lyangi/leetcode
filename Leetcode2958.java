import java.util.HashMap;

public class Leetcode2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        if (k == n)
            return n;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int ans = 0;
        for (int r = 0; r < n; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.getOrDefault(nums[r], 0) > k) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
