public class Leetcode209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        int l = 0;
        int sum = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
            while (sum >= target) {
                ans = Math.min(ans, r - l + 1);
                sum -= nums[l++];
            }
        }
        return ans <= n ? ans : 0;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3}));
    }
    
}
