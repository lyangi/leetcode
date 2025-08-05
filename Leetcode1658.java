public class Leetcode1658 {
    public static int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < x) {
            return -1;
        }

        // 1 1 4 2 3 . x = 5;
        int n = nums.length;
        int l = 0;
        int ans = Integer.MAX_VALUE;
        for (int r = 0; r < n; r++) {
            sum -= nums[r];
            while (sum < x && l <= r) {
                sum += nums[l];
                l++;
            }
            if (sum == x) {
                ans = Math.min(ans, n - 1 - r + l);
            }
            
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    // 反向
    public static int minOperations2(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < x) {
            return -1;
        }

        int n = nums.length;
        int l = 0;
        int ans = -1;
        int current = 0;
        for (int r = 0; r < n; r++) {
            current += nums[r];
            while (sum - current < x) {
                current -= nums[l];
                l++;
            }
            if (sum - current == x) {
                ans = Math.max(ans, r - l + 1);
            }
        }
        return ans == -1 ? -1 : n - ans;
    }
    public static void main(String[] args) {
        System.out.println(minOperations2(new int[]{1,1,4,2,3}, 5));
    }
}
