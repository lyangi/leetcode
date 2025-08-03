public class Leetcode713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int n = nums.length;
        int l = 0;
        int ans = 0;
        int product = 1;
        for (int r = 0; r < n; r++) {
            product *= nums[r];
            while (product >= k) {
                product /= nums[l++];
            }
            ans += r - l + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numSubarrayProductLessThanK(new int[] {10,5,2,6}, 100));
    }
}
