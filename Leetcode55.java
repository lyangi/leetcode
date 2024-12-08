public class Leetcode55 {
    public static boolean canJump(int[] nums) {
        int g = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= g) {
                g = i;
            }
        }
        return g == 0;
    }

    public static boolean canJump2(int[] nums) {
        int gas = 0;
        for (int n : nums) {
            if (gas < 0) {
                return false;
            } else if (gas < n) {
                gas = n;
            }
            gas--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(canJump2(nums));
    }
}
