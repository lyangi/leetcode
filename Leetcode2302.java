public class Leetcode2302 {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long ans = 0;
        long sum = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while (sum * (r - l + 1) >= k) {
                sum -= nums[l];
                l++;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}
