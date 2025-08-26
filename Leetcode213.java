public class Leetcode213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n - 1; i++) {
            int cur = Math.max(p1, p0 + nums[i]);
            p0 = p1;
            p1 = cur;
        }
        int q0 = 0, q1 = 0;
        for (int i = 1; i < n; i++) {
            int cur = Math.max(q1, q0 + nums[i]);
            q0 = q1;
            q1 = cur;
        }
        return Math.max(p1, q1);
    }
}
